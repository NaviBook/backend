package KNU.Navibook.server.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name="BOOKINFO_ID")
    private Long id;

    private String bookName;

    private String writer;

    //@OneToMany(mappedBy = "bookInfo", fetch = FetchType.EAGER)
    //@JsonManagedReference // 순환 참조 막기 위해서 직렬화 방향을 설정
    //private List<Book> bookList = new ArrayList<>();

}
