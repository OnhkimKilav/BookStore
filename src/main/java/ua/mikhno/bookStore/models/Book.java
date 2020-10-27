package ua.mikhno.bookStore.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@EqualsAndHashCode(of = {"title", "description"})
@RequiredArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ")
    @SequenceGenerator(name = "BOOK_SEQ", sequenceName = "BOOK_SEQ", allocationSize = 1)
    @Column(name = "BOOK_ID")
    private long id;

    @Column(name = "TITLE")
    @NonNull
    private String title;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "RELEASE_DATE")
    @NonNull
    private Date releaseDate;

    @Column(name = "DESCRIPTION")
    @NonNull
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    @NonNull
    private Genre genre;

    @Column(name = "BESTSELLER")
    @NonNull
    private boolean bestseller;

    @Column(name = "PRICE")
    @NonNull
    private double price;

    /*Наличие книги в магазине*/
    @Column(name = "AVAILABILITY")
    @NonNull
    private boolean availability;

    /*Скидка на книгу, есть или нету*/
    @Column(name = "DISCOUNT")
    @NonNull
    private boolean discount;
}
