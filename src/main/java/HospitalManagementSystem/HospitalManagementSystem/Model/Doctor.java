package HospitalManagementSystem.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int doctorId;
    private String doctorImage;
    private String doctorInformation;
    private String doctorName;
    private String doctorSpecialization;
    private long doctorContactDetails;
    private String doctorWorkSchedule;
//    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

	public int getDoctorId()
	{
		return doctorId;
	}

	public void setDoctorId(int doctorId)
	{
		this.doctorId = doctorId;
	}

	public String getDoctorImage()
	{
		return doctorImage;
	}

	public void setDoctorImage(String doctorImage)
	{
		this.doctorImage = doctorImage;
	}

	public String getDoctorInformation()
	{
		return doctorInformation;
	}

	public void setDoctorInformation(String doctorInformation)
	{
		this.doctorInformation = doctorInformation;
	}

	public String getDoctorName()
	{
		return doctorName;
	}

	public void setDoctorName(String doctorName)
	{
		this.doctorName = doctorName;
	}

	public String getDoctorSpecialization()
	{
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization)
	{
		this.doctorSpecialization = doctorSpecialization;
	}

	public long getDoctorContactDetails()
	{
		return doctorContactDetails;
	}

	public void setDoctorContactDetails(long doctorContactDetails)
	{
		this.doctorContactDetails = doctorContactDetails;
	}

	public String getDoctorWorkSchedule()
	{
		return doctorWorkSchedule;
	}

	public void setDoctorWorkSchedule(String doctorWorkSchedule)
	{
		this.doctorWorkSchedule = doctorWorkSchedule;
	}

	public List<Patient> getPatients()
	{
		return patients;
	}

	public void setPatients(List<Patient> patients)
	{
		this.patients = patients;
	}
    
    

//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
}
