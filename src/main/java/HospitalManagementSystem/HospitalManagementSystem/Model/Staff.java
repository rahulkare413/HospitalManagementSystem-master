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
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "staffIdGene")
    @SequenceGenerator(name = "staffIdGene",initialValue = 1000,allocationSize = 10)


    private int staffId;
    private String staffName;
    private String staffRole;
    private Long staffContactDetails;
    private String staffWorkSchedule;
	public int getStaffId()
	{
		return staffId;
	}
	public void setStaffId(int staffId)
	{
		this.staffId = staffId;
	}
	public String getStaffName()
	{
		return staffName;
	}
	public void setStaffName(String staffName)
	{
		this.staffName = staffName;
	}
	public String getStaffRole()
	{
		return staffRole;
	}
	public void setStaffRole(String staffRole)
	{
		this.staffRole = staffRole;
	}
	public Long getStaffContactDetails()
	{
		return staffContactDetails;
	}
	public void setStaffContactDetails(Long staffContactDetails)
	{
		this.staffContactDetails = staffContactDetails;
	}
	public String getStaffWorkSchedule()
	{
		return staffWorkSchedule;
	}
	public void setStaffWorkSchedule(String staffWorkSchedule)
	{
		this.staffWorkSchedule = staffWorkSchedule;
	}
    
    
}
