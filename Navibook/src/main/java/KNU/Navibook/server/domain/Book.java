package KNU.Navibook.server.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long book_id;

    private String bookshelf_Id;

    private String status;

    private String self_floor;

}
