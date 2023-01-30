package KNU.Navibook.server.repository;
import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface BookInfoRepository extends JpaRepository<BookInfo, Long>{
   List<BookInfo> findAll();
    // 단순 값 하나를 조회
   List<BookInfo> findBybookName(String book);
   List<BookInfo> findBybookNameContaining(String keyword);

}
