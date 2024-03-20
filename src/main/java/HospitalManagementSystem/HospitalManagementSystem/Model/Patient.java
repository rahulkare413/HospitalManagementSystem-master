package HospitalManagementSystem.HospitalManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "patientIdGenerator")
    @SequenceGenerator(name = "patientIdGenerator",initialValue = 1000,allocationSize = 100)

    private int patientId;
    private String patientName;
    private String patientAddress;
    private long patientContactDetails;
    private String patientMedicalHistory;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @OneToOne(mappedBy = "patient")
    private Billing billing;
}
