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

    private int shelf_floor;

    private int position_x;
    private int position_y;
    private int width;
    private int height;
    private String library_floor;

    //양방햐 매핑을 위해 추가
//    @OneToMany(mappedBy = "bookshelf")
//    private List<Book> books = new ArrayList<>();

}
