package pro.sky.java.course2.employee.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employee.Employee;
import pro.sky.java.course2.employee.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName){
        Employee result = employeeService.add(firstName, lastName);
        return generateMessage(result, "Успешно создан");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName){
        Employee result = employeeService.remove(firstName, lastName);
        return generateMessage(result, "удален");
    }

    @GetMapping("/find")
    public String find(@RequestParam String firstName, @RequestParam String lastName){
        Employee result = employeeService.find(firstName, lastName);
    }

    private String generateMessage(Employee employee, String status){
        return String.format("Сотрудник %s %s %s.", employee.getLastName(),
                employee.getFirstName(), status);
    }
}
