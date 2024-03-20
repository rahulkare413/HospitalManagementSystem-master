package HospitalManagementSystem.HospitalManagementSystem.Repository;

import HospitalManagementSystem.HospitalManagementSystem.Model.Appointment;
import HospitalManagementSystem.HospitalManagementSystem.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    @Query(value = "select * from appointment",nativeQuery = true)
    public List<Appointment> displayAllAppointment();

    @Query(value = "select * from appointment where appointment_id=:id",nativeQuery = true)
    public Appointment appointmentFetchById(@Param("id") int id);

    @Query(value = "select * from doctor where doctor_id=:id",nativeQuery = true)
    public Doctor getSingleProduct(@Param("id")int id);

//    @Query(value = "SELECT COUNT(*) FROM appointment WHERE doctor_id = :doctorId", nativeQuery = true)
//    int getAppointmentCountBySmallerThan3(@Param("doctorId") int doctorId);

    @Query(value = "SELECT * FROM appointment WHERE doctor_id = :doctorId AND appointment_date = :appointmentDate", nativeQuery = true)
    List<Appointment> findByDoctorAndAppointmentDate(@Param("doctorId") int doctorId, @Param("appointmentDate") String appointmentDate);
    
    @Query(value = "SELECT appointment_date FROM appointment WHERE doctor_id = :doctorId", nativeQuery = true)
    List<String> getAppointmentByDoctorId(@Param("doctorId") int doctorId);












}


