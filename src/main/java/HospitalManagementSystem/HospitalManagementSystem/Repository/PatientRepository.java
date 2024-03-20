package HospitalManagementSystem.HospitalManagementSystem.Repository;

import HospitalManagementSystem.HospitalManagementSystem.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value = "select * from patient",nativeQuery = true)
    public List<Patient> displayAllPatientsData();

    @Query(value = "select * from patient where patient_id=:id",nativeQuery = true)
    public Patient getSinglePatientId(@Param("id") int id);
}
