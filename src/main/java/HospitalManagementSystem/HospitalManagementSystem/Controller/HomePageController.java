package HospitalManagementSystem.HospitalManagementSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homePage")
public class HomePageController {

    @GetMapping("/")
    public String displayHomePage(){
        return "index";


    }
}
