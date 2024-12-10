package com.example.Crud.controller;
import com.example.Crud.entity.Employee;
import com.example.Crud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get the employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

        // add new employee
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        // call object
        Employee employee = new Employee();
        //using model to retrieve data
        model.addAttribute("employee",employee);
        return "employees/employee-form";
    }

    // Save Employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
      return "redirect:/employees/list";
    }

    @GetMapping("/ShowFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int theID , Model model){
        Employee employee = employeeService.findById(theID);
        model.addAttribute(employee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}










