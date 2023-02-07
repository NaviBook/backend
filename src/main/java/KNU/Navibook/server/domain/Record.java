package KNU.Navibook.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Record{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // 1
    @JoinColumn(name = "USER_ID") // 2
    private User user;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID") // 2
    private Book book;

    private String giveDate;
    private String takeDate;
}
