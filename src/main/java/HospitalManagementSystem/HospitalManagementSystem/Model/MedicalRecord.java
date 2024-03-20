package HospitalManagementSystem.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicalRecord")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "medicalIdGenerator")
    @SequenceGenerator(name = "appointmentGenerator",initialValue = 100000,allocationSize = 100)

    private long recordId;
    private int patientId;
    private String diagnosis;
    private String treatmentDetails;
    private String medication;
	public long getRecordId()
	{
		return recordId;
	}
	public void setRecordId(long recordId)
	{
		this.recordId = recordId;
	}
	public int getPatientId()
	{
		return patientId;
	}
	public void setPatientId(int patientId)
	{
		this.patientId = patientId;
	}
	public String getDiagnosis()
	{
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis)
	{
		this.diagnosis = diagnosis;
	}
	public String getTreatmentDetails()
	{
		return treatmentDetails;
	}
	public void setTreatmentDetails(String treatmentDetails)
	{
		this.treatmentDetails = treatmentDetails;
	}
	public String getMedication()
	{
		return medication;
	}
	public void setMedication(String medication)
	{
		this.medication = medication;
	}
    
    
}
