package HospitalManagementSystem.HospitalManagementSystem.Repository;

import HospitalManagementSystem.HospitalManagementSystem.Model.Staff;
import org.hibernate.query.criteria.JpaCoalesce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

    @Query(value = "select * from staff",nativeQuery = true)
    public List<Staff> displayAllStaff();

    @Query(value = "select * from staff where staff_id=:id",nativeQuery = true)
    public void fetchByStaffId();
}
