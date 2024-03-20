package HospitalManagementSystem.HospitalManagementSystem.Service;

import HospitalManagementSystem.HospitalManagementSystem.Model.Doctor;
import HospitalManagementSystem.HospitalManagementSystem.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void addDoctors(Doctor doctor){
        doctorRepository.save(doctor);

    }

    public List<Doctor> displayDoctorList(){
      return  doctorRepository.findAll();
    }

    public Doctor fetchDoctorObject(int id) {
        Doctor d = null;
        try{
            d = doctorRepository.getSingleProduct(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return d;
    }

        public void updateDoctor(Doctor d){
        doctorRepository.save(d);
        }

    public void deleteDoctorById(int id) {
        try {
            doctorRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
