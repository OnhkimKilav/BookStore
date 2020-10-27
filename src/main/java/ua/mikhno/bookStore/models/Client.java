package ua.mikhno.bookStore.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"phoneNumber", "email"})
@RequiredArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQ")
    @SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "CLIENT_SEQ", allocationSize = 1)
    @Column(name = "CLIENT_ID")
    private long id;

    @NonNull
    @Column(name = "NAME")
    private String name;

    @NonNull
    @Column(name = "AGE")
    private int age;

    @NonNull
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NonNull
    @Column(name = "EMAIL")
    private String email;

    @NonNull
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "client")
    private Set<Order> orders;
}
