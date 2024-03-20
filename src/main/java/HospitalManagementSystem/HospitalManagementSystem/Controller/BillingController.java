package HospitalManagementSystem.HospitalManagementSystem.Controller;

import HospitalManagementSystem.HospitalManagementSystem.Model.Billing;
import HospitalManagementSystem.HospitalManagementSystem.Model.Patient;
import HospitalManagementSystem.HospitalManagementSystem.Service.BillingService;
import HospitalManagementSystem.HospitalManagementSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @Autowired
    private PatientService displayAllPatient;
    @GetMapping("/displayAll")
    public String displayBill(Model model){
        List<Billing> list = billingService.displayBillingDetails();
        model.addAttribute("displayBill",list);
        return "displayBill";
    }

    @GetMapping("/updateBillDetails/{id}")
    public String updateBillDetails(@PathVariable int id , Model model){
        List<Patient> patients = displayAllPatient.displayAllPatient();
        Billing b = billingService.fetchedBillObject(id);
        model.addAttribute("updateBill",b);
        model.addAttribute("patients", patients);
        billingService.fetchedBillObject(id);

        return "updateBill";
    }
    @PostMapping("/updateBill")
    public String updateBillData(Billing b){
        billingService.updateBillData(b);
        return "redirect:/billing/displayAll";

    }

    @GetMapping("/addBill")
    public String addBill(Model model){
        List<Patient> patients = displayAllPatient.displayAllPatient();
        model.addAttribute("newBill", new Billing());
        model.addAttribute("patients", patients);
        return "addBill";
    }

    @PostMapping("/addNewBill")
    public String addNewBill(@ModelAttribute("newBill") Billing billing){
        billingService.addBilling(billing);
        return "redirect:/billing/displayAll";

    }

    @GetMapping("/deleteBill/{id}")
    public String deleteBill(@PathVariable int id){
        billingService.deleteBill(id);
        return "redirect:/billing/displayAll";


    }
}
