package ua.mikhno.bookStore.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.mikhno.bookStore.services.client.ClientCRUDServiceImpl;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"count", "price", "deliveryAddress", "client"})
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_SEQ", allocationSize = 1)
    @Column(name = "ORDERS_ID")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATED")
    @NonNull
    private Date dateCreated;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    @NonNull
    private Status status;

    @Column(name = "DELIVERY_ADDRESS")
    @NonNull
    private String deliveryAddress;

    @Column(name = "COUNT")
    @NonNull
    private int count;

    @Column(name = "PRICE")
    @NonNull
    private double price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID", referencedColumnName="CLIENT_ID")
    @NonNull
    private Client client;
}

