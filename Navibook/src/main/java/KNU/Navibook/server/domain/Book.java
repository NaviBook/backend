package KNU.Navibook.server.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name="BOOKINFO_ID")
    private BookInfo bookInfo;

    @ManyToOne
    @JoinColumn(name="BOOKSHELF_ID")
    private BookShelf bookShelf;

    private Boolean status;

    private Long selfFloor;


}
