package HospitalManagementSystem.HospitalManagementSystem.Repository;

import HospitalManagementSystem.HospitalManagementSystem.Model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Integer> {

    @Query(value = "select * from billing ",nativeQuery = true)
    public List<Billing> displayBillData();

    @Query(value = "select * from billing where invoice_id=:id",nativeQuery = true)
    public Billing fetchedBillObject(int id);
}
