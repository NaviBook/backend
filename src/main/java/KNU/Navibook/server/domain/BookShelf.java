package KNU.Navibook.server.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookShelf {

    @Id
    @Column(name = "BOOKSHELF_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shelfFloor;

    private Long positionX;
    private Long positionY;
    private Long width;
    private Long height;
    private String libraryFloor;

    //양방향 매핑을 위해 추가
    //@OneToMany(mappedBy = "bookShelf")
    //@JsonManagedReference // 순환 참조 막기 위해서 직렬화 방향을 설정
    //private List<Book> bookList = new ArrayList<>();
}
