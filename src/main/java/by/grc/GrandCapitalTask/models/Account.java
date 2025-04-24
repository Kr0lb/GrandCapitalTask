package by.grc.GrandCapitalTask.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnlyProperty
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "account")
    private List<Deposit> deposits;

    private Double balance;
}

