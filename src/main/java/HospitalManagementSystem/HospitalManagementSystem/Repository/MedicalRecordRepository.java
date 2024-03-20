package HospitalManagementSystem.HospitalManagementSystem.Repository;

import HospitalManagementSystem.HospitalManagementSystem.Model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {

    @Query(value = "select * from medical_record",nativeQuery = true)
    public List<MedicalRecord> displayAllRecords();

    @Query(value = "select * from medical_record where record_id=:id", nativeQuery = true)
    public MedicalRecord addMedicalRecordsByObject(@Param("id") int id);

}
