package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.dto.ServiceDto;
import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.service.contract.IAttachServiceService;
import com.codegym.model.service.contract.IContractDetailService;
import com.codegym.model.service.contract.IContractService;
import com.codegym.model.service.customer.ICustomerService;
import com.codegym.model.service.employee.IEmployeeService;
import com.codegym.model.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping({"", "/list"})
    public String showList(Model model) {
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "/contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("services", serviceService.findAll());
        return "/contract/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDto contractDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasFieldErrors()) {
            initCreateContract(model);
            return "/contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("msg", "Create success");
            return "redirect:/contract/list";
        }
    }

    @GetMapping("/create-detail")
    public String showCreateDetail(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        model.addAttribute("attachServices", attachServiceService.findAll());
        model.addAttribute("contracts", contractService.findAll());
        return "/contract/create-detail";
    }

    @PostMapping("/create-detail")
    public String create(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasFieldErrors()) {
            initCreateContractDetail(model);
            return "/contract/create-detail";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("msg", "Create success");
            return "redirect:/contract/list";
        }
    }

    private void initCreateContract(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);

        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        List<Service> services = serviceService.findAll();
        model.addAttribute("services", services);
    }

    private void initCreateContractDetail(Model model) {
        List<AttachService> attachServices = attachServiceService.findAll();
        model.addAttribute("attachServices", attachServices);

        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
    }
}
