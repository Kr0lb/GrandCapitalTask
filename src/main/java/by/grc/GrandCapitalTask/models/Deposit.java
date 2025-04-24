package by.grc.GrandCapitalTask.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "deposit")
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_ido")
    private Account account;

    private Double startBalance;

    private Double amount;

    private Double amountStopped;
}
