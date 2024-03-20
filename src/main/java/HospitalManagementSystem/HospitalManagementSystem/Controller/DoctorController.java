package HospitalManagementSystem.HospitalManagementSystem.Controller;

import HospitalManagementSystem.HospitalManagementSystem.Model.Doctor;
import HospitalManagementSystem.HospitalManagementSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
        @GetMapping("/addDoctor")
        public String addDoctors(Model model){
            model.addAttribute("newDoctor",new Doctor());
            return "addDoctor";
        }

        @PostMapping("/addNewDoctor")
        public String addNewDoctor(@ModelAttribute("newDoctor") Doctor doctor){
            doctorService.addDoctors(doctor);
            return "redirect:/doctor/displayDoctors";
        }

    @GetMapping("/updateDoctorDetails/{id}")
    public String updateDoctor(@PathVariable int id , Model model ){
        Doctor d = doctorService.fetchDoctorObject(id);
        model.addAttribute("currentDoctor",d);
        doctorService.fetchDoctorObject(id);
        return "updateDoctor";
    }

    @PostMapping("/updateDoctor")
    public String updateDoctorData(Doctor d){
        doctorService.updateDoctor(d);
        return "redirect:/doctor/displayDoctors";

    }

    @GetMapping("/deleteDoctor/{id}")
    public String deleteDoctorDetails(@PathVariable int id){
        doctorService.deleteDoctorById(id);
        return "redirect:/doctor/displayDoctors";
    }
        @GetMapping("/displayDoctors")
        public String displayDoctorDetails(Model model){
            List<Doctor> doctorList = doctorService.displayDoctorList();
            model.addAttribute("displayDr",doctorList);
            return "displayDoctors";

        }
}
