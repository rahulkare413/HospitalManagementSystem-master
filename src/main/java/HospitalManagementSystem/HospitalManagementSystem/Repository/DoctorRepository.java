package HospitalManagementSystem.HospitalManagementSystem.Repository;

import HospitalManagementSystem.HospitalManagementSystem.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query(value = "select * from doctor",nativeQuery = true)
    public List<Doctor> displayDoctor();

    @Query(value = "select * from doctor where doctor_id=:id",nativeQuery = true)
    public Doctor getSingleProduct(@Param("id")int id);
}
