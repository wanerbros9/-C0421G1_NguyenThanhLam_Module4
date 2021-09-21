package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.service.employee.IDivisionService;
import com.codegym.model.service.employee.IEducationDegreeService;
import com.codegym.model.service.employee.IEmployeeService;
import com.codegym.model.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @GetMapping({"", "/list"})
    public String showList(Model model, @PageableDefault(value = 5)Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        return "/employee/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("positions", positionService.findAll());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasFieldErrors()) {
            initCreateEmployee(model);
            return "/employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("msg", "Success");
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("employeeDto", this.employeeService.findById(id));
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("positions", positionService.findAll());
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute @Validated EmployeeDto employeeDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasFieldErrors()) {
            initCreateEmployee(model);
            return "/employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("msg", "Success");
            return "redirect:/employee/list";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id,
                         RedirectAttributes redirectAttributes) {
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete success");
        return "redirect:/employee/list";
    }

    @PostMapping("/search")
    public String list(Model model,
                       @PageableDefault(value = 5) Pageable pageable,
                       @RequestParam (value = "name") String name) {
        Page<Employee> employees = employeeService.findCustomerByCustomerName(name,pageable);
        model.addAttribute("employees", employees);
        return "/employee/list";
    }

    private void initCreateEmployee(Model model) {
        List<Division> divisions = divisionService.findAll();
        model.addAttribute("divisions", divisions);

        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        model.addAttribute("educationDegrees", educationDegrees);

        List<Position> positions = positionService.findAll();
        model.addAttribute("positions", positions);
    }
}
