package HospitalManagementSystem.HospitalManagementSystem.Controller;

import HospitalManagementSystem.HospitalManagementSystem.Model.Patient;
import HospitalManagementSystem.HospitalManagementSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/displayPatient")
    public String displayAllPatients(Model model){
        List<Patient> temp = patientService.displayAllPatient();
        model.addAttribute("displayPatient",temp);
        return "displayPatient";
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model){
        model.addAttribute("addPatient", new Patient());
        return "addPatient";

    }
        @PostMapping("/addNewPatient")
        public String addNewPatient(@ModelAttribute("addPatient") Patient patient){
        patientService.addPatients(patient);
        return "redirect:/patient/displayPatient";
        }

        @GetMapping("/updatePatient/{id}")
        public String updatePatientById(@PathVariable int id , Model model){
        Patient p = patientService.updateByFetchingObject(id);
        model.addAttribute("currentPatient",p);
        patientService.updateByFetchingObject(id);
        return "updatePatient";
        }

        @PostMapping("/updatePatient")
        public String updatePatient(Patient patient){
        patientService.updatePatientById(patient);
        return  "redirect:/patient/displayPatient";
        }
        @GetMapping("/deletePatient/{id}")
        public String deletePatientById(@PathVariable int id){
        patientService.deletePatientById(id);
        return "redirect:/patient/displayPatient";

        }


}
