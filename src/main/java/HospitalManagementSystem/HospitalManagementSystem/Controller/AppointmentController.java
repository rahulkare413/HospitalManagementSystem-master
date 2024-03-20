package HospitalManagementSystem.HospitalManagementSystem.Controller;

import HospitalManagementSystem.HospitalManagementSystem.Model.Appointment;
import HospitalManagementSystem.HospitalManagementSystem.Model.Doctor;
import HospitalManagementSystem.HospitalManagementSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/displayAll")
    public String displayAllAppointment(Model model){
        List<Appointment> list = appointmentService.displayAllAppointment();
        model.addAttribute("list", list);
        return "displayAppointment";

    }


    @GetMapping("/addAppointment")
    public String showAddAppointmentForm(@RequestParam("doctorId") int doctorId,
                                         @RequestParam("doctorName") String doctorName,
                                         @RequestParam("doctorSpecialization") String doctorSpecialization,
                                         Model model) throws ParseException {

        Appointment appointment = new Appointment();
        
        List<String> listOfAppointments = appointmentService.getAllAppointments(doctorId);
        for(int i = 0; i<listOfAppointments.size(); i++)
        {
        	System.out.println("these are appointments : " + listOfAppointments.get(i));
        }
        
        // Get the available time slots
        List<String> availableTimeSlots = AppointmentUtil.getAvailableTimeSlots(listOfAppointments);
        
        // Add the available time slots to the model
        model.addAttribute("availableTimeSlots", availableTimeSlots);

        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);
        doctor.setDoctorName(doctorName);
        doctor.setDoctorSpecialization(doctorSpecialization);
        appointment.setDoctor(doctor);


        model.addAttribute("addNewAppointment", appointment);

        return "addAppointment";
    }


    @PostMapping("/addNewAppointment")
    public String addNewAppointment(@ModelAttribute("addNewAppointment") Appointment appointment){
       Appointment appointmentData = appointmentService.addAppointment(appointment);
       System.out.println(appointmentData.getAppointmentDate());
        return "redirect:/appointment/displayAll";

    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointmentByItsId(@PathVariable int id){
        appointmentService.deleteAppointment(id);
        return "redirect:/appointment/displayAll";


    }


}
