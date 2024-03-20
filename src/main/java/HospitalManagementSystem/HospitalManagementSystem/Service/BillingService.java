package HospitalManagementSystem.HospitalManagementSystem.Service;

import HospitalManagementSystem.HospitalManagementSystem.Model.Billing;
import HospitalManagementSystem.HospitalManagementSystem.Model.Doctor;
import HospitalManagementSystem.HospitalManagementSystem.Repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;

    public List<Billing> displayBillingDetails(){
      return billingRepository.findAll();
    }

    public void addBilling(Billing billing){
        billingRepository.save(billing);
    }

    public Billing fetchedBillObject(int id) {
        Billing b = null;
        try{
            b = billingRepository.fetchedBillObject(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    public void updateBillData(Billing b){
        billingRepository.save(b);

    }

    public void deleteBill(int id){
        billingRepository.deleteById(id);
    }
}
