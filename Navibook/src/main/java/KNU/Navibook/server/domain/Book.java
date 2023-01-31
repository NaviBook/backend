package KNU.Navibook.server.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    //@JsonBackReference // 순환 참조 막기 위해서 직렬화 방향을 설정
    @JoinColumn(name="BOOKINFO_ID")
    private BookInfo bookInfo;

    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name="BOOKSHELF_ID")
    private BookShelf bookShelf;

    private Boolean status;

    private Long selfFloor;


}
