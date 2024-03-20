package HospitalManagementSystem.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "billing")
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "billingIdGene")
    @SequenceGenerator(name = "billingIdGene",initialValue = 500,allocationSize = 50)

    private int invoiceId;
    @OneToOne
    @JoinColumn(name = "patient_id", unique = true)
    private Patient patient;
    private int age;
    private long phoneNumber;
    private double weight;
    private float height;
    private double amount;
    private String paymentStatus;
    private Date invoiceDate;
}
