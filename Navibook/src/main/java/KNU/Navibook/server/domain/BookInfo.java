package KNU.Navibook.server.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOKINFO_ID")
    private Long id;

    private String bookName;

    private String writer;

//    @OneToMany(mappedBy = "bookInfo", fetch = FetchType.EAGER)
//    private List<Book> bookList = new ArrayList<>();

}
