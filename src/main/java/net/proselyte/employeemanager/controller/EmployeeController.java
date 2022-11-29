package net.proselyte.employeemanager.controller;
import net.proselyte.employeemanager.model.employee;
import net.proselyte.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    public void setBookService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public String listEmployee(Model model){
        model.addAttribute("employee", new employee());
        model.addAttribute("listEmployee", this.employeeService.listEmployee());

        return "employee";
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("employee") employee employee){
        if(employee.getId() == 0){
            this.employeeService.addEmployee(employee);
        }else {
            this.employeeService.updateEmployee(employee);
        }

        return "redirect:/employee";
    }

    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        this.employeeService.removeEmployee(id);

        return "redirect:/employee";
    }

    @RequestMapping("edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployee", this.employeeService.listEmployee());

        return "employee";
    }

    @RequestMapping("employeedata/{id}")
    public String employeeData(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));

        return "employeedata";
    }
}
