package HospitalManagementSystem.HospitalManagementSystem.Service;

import HospitalManagementSystem.HospitalManagementSystem.Model.Patient;
import HospitalManagementSystem.HospitalManagementSystem.Model.Staff;
import HospitalManagementSystem.HospitalManagementSystem.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> displayAllStaffDetails(){
        return staffRepository.findAll();

    }

    public void addStaffMembers(Staff staff){
        staffRepository.save(staff);
    }

    public Staff staffIdFetchById(int id){
        Staff s = null;
        try{
            s = staffRepository.findById(id).orElse(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;

    }

    public void updateStaffDetails(Staff staff){
            staffRepository.save(staff);
    }

    public void deleteStaffByItsId(int id){
        staffRepository.deleteById(id);
    }
}
