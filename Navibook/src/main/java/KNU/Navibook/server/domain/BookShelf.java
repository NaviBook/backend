package KNU.Navibook.server.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class BookShelf {

    @Id
    @GeneratedValue
    @Column(name = "BOOKSHELF_ID")
    private Long id;

    private Long shelfFloor;

    private Long positionX;
    private Long positionY;
    private Long width;
    private Long height;
    private String libraryFloor;

    //양방향 매핑을 위해 추가
//    @OneToMany(mappedBy = "bookshelf")
//    private List<Book> bookList = new ArrayList<>();
}
