package HospitalManagementSystem.HospitalManagementSystem.Service;

import HospitalManagementSystem.HospitalManagementSystem.Model.Appointment;
import HospitalManagementSystem.HospitalManagementSystem.Model.Doctor;
import HospitalManagementSystem.HospitalManagementSystem.Model.Patient;
import HospitalManagementSystem.HospitalManagementSystem.Repository.AppointmentRepository;
import HospitalManagementSystem.HospitalManagementSystem.Repository.DoctorRepository;
import HospitalManagementSystem.HospitalManagementSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;



    public void createAppointment(int doctorId, int patientId, String fullName, String dateOfBirth,String gender,String phoneNumber,String reasonForVisit , String appointmentDate , String medicalConditions ) {

        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        System.out.println(doctor);
        if (doctor != null) {

            System.out.println(1);
                Appointment appointment = new Appointment();
                appointment.setDoctor(doctor);

                appointment.setFullName(fullName);

                Date dob = new Date();
                dob.setTime(Long.parseLong(dateOfBirth));
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");

                appointment.setDateOfBirth(simpleDateFormat.format(dob));

                appointment.setGender(gender);
                appointment.setPhoneNumber(phoneNumber);
                appointment.setReasonForVisit(reasonForVisit);

                Date date1 = new Date();
                date1.setTime(Long.parseLong(appointmentDate));
                SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd-MM-yyyy");

                SimpleDateFormat s1=new SimpleDateFormat("hr-mm");

                System.out.println(simpleDateFormat);
            System.out.println(simpleDateFormat1);
                appointment.setAppointmentDate(simpleDateFormat1.format(date1));
                appointment.setMedicalConditions(medicalConditions);

                appointmentRepository.save(appointment);

        } else {
            System.out.println("Doctor not found!");
        }
    }

    public List<Appointment> displayAllAppointment(){
        return appointmentRepository.findAll();

    }

    public Appointment addAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(int id){
        appointmentRepository.deleteById(id);

    }

	public List<String> getAllAppointments(int doctorId)
	{
		return appointmentRepository.getAppointmentByDoctorId(doctorId);
		
	}
}
