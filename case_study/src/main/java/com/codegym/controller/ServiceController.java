package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.dto.ServiceDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.service.service.IRentTypeService;
import com.codegym.model.service.service.IServiceService;
import com.codegym.model.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IServiceService serviceService;

    @GetMapping({"", "/list"})
    public String showList(Model model) {
        List<Service> services = serviceService.findAll();
        model.addAttribute("services", services);
        return "/service/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("serviceTypes", serviceTypeService.findAll());
        return "/service/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ServiceDto serviceDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasFieldErrors()) {
            initCreateService(model);
            return "/service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            redirectAttributes.addFlashAttribute("msg", "Create success");
            return "redirect:/service/list";
        }
    }

    private void initCreateService(Model model) {
        List<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("rentTypes", rentTypes);

        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        model.addAttribute("serviceTypes", serviceTypes);
    }

}
