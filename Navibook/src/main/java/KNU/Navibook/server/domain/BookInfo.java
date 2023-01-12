package KNU.Navibook.server.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.*;

@Entity
@Getter
@NoArgsConstructor
public class BookInfo {

    @Id
    @GeneratedValue
    private Long bookinfo_id;

    private String bookname;

    private String writer;

//    @OneToMany(mappedBy = "bookInfo")
//    private List<Book> books = new ArrayList<>();

}
