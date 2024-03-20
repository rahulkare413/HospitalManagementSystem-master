package HospitalManagementSystem.HospitalManagementSystem.Service;

import HospitalManagementSystem.HospitalManagementSystem.Model.Patient;
import HospitalManagementSystem.HospitalManagementSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> displayAllPatient(){
       return patientRepository.findAll();

    }

    public void addPatients(Patient p){
        patientRepository.save(p);
    }

    public Patient updateByFetchingObject(int id){
        Patient p = null;
        try{
            p = patientRepository.findById(id).orElse(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public void updatePatientById(Patient p){
        patientRepository.save(p);

    }

    public void deletePatientById(int id){
        patientRepository.deleteById(id);
    }
}
