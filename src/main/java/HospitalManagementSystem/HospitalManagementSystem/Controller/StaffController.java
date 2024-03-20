package HospitalManagementSystem.HospitalManagementSystem.Controller;

import HospitalManagementSystem.HospitalManagementSystem.Model.Staff;
import HospitalManagementSystem.HospitalManagementSystem.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
@Autowired
    private StaffService staffService;

    @GetMapping("/displayStaffDetails")
    public String displayStaffDetails(Model model){
        List<Staff> s = staffService.displayAllStaffDetails();
        model.addAttribute("displayStaff",s);
        return "displayStaff";

    }
    @GetMapping("/addStaff")
    public String addStaffMember(Model model){
        model.addAttribute("addStaff",new Staff());
        return "addStaff";
    }

    @PostMapping("/addNewStaff")
    public String addNewStaff(@ModelAttribute("addStaff") Staff staff){
        staffService.addStaffMembers(staff);
        return "redirect:/staff/displayStaffDetails";

    }

    @GetMapping("/updateStaff/{id}")
    public String updateStaffByItsId(@PathVariable int id , Model model){
        Staff s = staffService.staffIdFetchById(id);
        model.addAttribute("updateStaffDetails",s);
        staffService.staffIdFetchById(id);
        return "updateStaff";

    }

    @PostMapping("/updateStaff")
    public String updateStaff(Staff staff){
        staffService.addStaffMembers(staff);
        return "redirect:/staff/displayStaffDetails";
    }
    @GetMapping("/staffMemberDelete/{id}")
    public String deleteStaff(@PathVariable int id ){
        staffService.deleteStaffByItsId(id);
        return "redirect:/staff/displayStaffDetails";
    }

}
