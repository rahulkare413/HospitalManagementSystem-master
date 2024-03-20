package HospitalManagementSystem.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment" )
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appointmentGenerator")
    @SequenceGenerator(name = "appointmentGenerator",initialValue = 50000,allocationSize = 500)
    @Column(name = "appointment_id")
    private int appointmentId;
    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String reasonForVisit;
    private String appointmentDate;
    private String medicalConditions;
	public int getAppointmentId()
	{
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId)
	{
		this.appointmentId = appointmentId;
	}
	public Doctor getDoctor()
	{
		return doctor;
	}
	public void setDoctor(Doctor doctor)
	{
		this.doctor = doctor;
	}
	public String getFullName()
	{
		return fullName;
	}
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getReasonForVisit()
	{
		return reasonForVisit;
	}
	public void setReasonForVisit(String reasonForVisit)
	{
		this.reasonForVisit = reasonForVisit;
	}
	public String getAppointmentDate()
	{
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate)
	{
		this.appointmentDate = appointmentDate;
	}
	public String getMedicalConditions()
	{
		return medicalConditions;
	}
	public void setMedicalConditions(String medicalConditions)
	{
		this.medicalConditions = medicalConditions;
	}
    
    



}
