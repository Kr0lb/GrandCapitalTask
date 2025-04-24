package by.grc.GrandCapitalTask.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

@Getter
@Setter
@Entity
@Table(name = "phone_data")
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnlyProperty
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(unique = true, nullable = false,length = 13)
    private String phone;
}
