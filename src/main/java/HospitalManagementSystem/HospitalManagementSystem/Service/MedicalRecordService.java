package HospitalManagementSystem.HospitalManagementSystem.Service;

import HospitalManagementSystem.HospitalManagementSystem.Model.Doctor;
import HospitalManagementSystem.HospitalManagementSystem.Model.MedicalRecord;
import HospitalManagementSystem.HospitalManagementSystem.Repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;


    public List<MedicalRecord> displayAllMedicalRecords() {
        return medicalRecordRepository.findAll();

    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }


    public MedicalRecord fetchMedicalRecordObject(int id) {
        MedicalRecord record = null;
        try {
            record = medicalRecordRepository.addMedicalRecordsByObject(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }

    public void updateMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }

    public void deleteMedicalRecordById(int id) {
        try {
            medicalRecordRepository.deleteById((long) id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
