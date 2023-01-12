package KNU.Navibook.server.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="BOOKINFO_ID")
    private BookInfo bookInfo;

    @ManyToOne
    @JoinColumn(name="BOOKSHELF_ID")
    private BookShelf bookShelf;

    private String status;

    private Long self_floor;
}
