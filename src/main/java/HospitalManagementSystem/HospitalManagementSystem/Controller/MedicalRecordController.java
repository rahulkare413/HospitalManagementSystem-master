package HospitalManagementSystem.HospitalManagementSystem.Controller;

import HospitalManagementSystem.HospitalManagementSystem.Model.MedicalRecord;
import HospitalManagementSystem.HospitalManagementSystem.Model.Patient;
import HospitalManagementSystem.HospitalManagementSystem.Service.MedicalRecordService;
import HospitalManagementSystem.HospitalManagementSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medicalRecord")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService recordService;

    @Autowired
    private PatientService displayAllPatient;
    @GetMapping("/displayAll")
    public String displayMedicalRecords(Model model){
        List<MedicalRecord> list = recordService.displayAllMedicalRecords();
        model.addAttribute("medicalRecord",list);
        return "displayMedicalRecord";

    }

    @GetMapping("/addMedicalRecord")
    public String addMedicalRecord(Model model){
        List<Patient> patients = displayAllPatient.displayAllPatient();
        model.addAttribute("addNewRecord",new MedicalRecord());
        model.addAttribute("patients", patients); // Add patients to the model
        return "addMedicalRecord";
    }

    @PostMapping("/addNewMedicalRecord")
    public String addNewRecords(@ModelAttribute("addNewRecord") MedicalRecord medicalRecord){
        recordService.addMedicalRecord(medicalRecord);
        return "redirect:/medicalRecord/displayAll";

    }

    @GetMapping("/updateMedicalRecordDetails/{id}")
    public String updateMedicalRecord(@PathVariable int id ,Model model){
        MedicalRecord record = recordService.fetchMedicalRecordObject(id);
        model.addAttribute("updateMedicalRecord",record);
        recordService.fetchMedicalRecordObject(id);
        return "updateMedicalRecord";

    }
    @PostMapping("/updateMedicalRecord")
    public String updateMedicalRecords(MedicalRecord medicalRecord){
        recordService.updateMedicalRecord(medicalRecord);
        return "redirect:/medicalRecord/displayAll";


    }
    @GetMapping("/deleteMedicalRecord/{id}")
    public String deleteMedicalRecord(@PathVariable int id ){
        recordService.deleteMedicalRecordById(id);
        return "redirect:/medicalRecord/displayAll";

    }
}
