package KNU.Navibook.server.repository;
import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface BookInfoRepository extends JpaRepository<BookInfo, Long>{
   List<BookInfo> findAll();
    // 단순 값 하나를 조회
   List<BookInfo> findBybookName(String book);
   List<BookInfo> findBybookNameContaining(String keyword);
   BookInfo findByid(Long id);

   //@Query이용하여 jpql작성
    @Query(value = "SELECT * FROM BOOK_INFO order by RAND() limit :count",nativeQuery = true)
    List<BookInfo> findRandom(@Param("count") int count);


    BookInfo save(BookInfo bookInfo);


    //void deleteByid(Long id);
    //   @Modifying(clearAutomatically = true)
//    @Query("UPDATE BookInfo m SET m.bookName = :bookname, m.writer = :writer where m.id = :id")
//    int updateByid(@Param(value="bookname")String bookname,@Param(value="writer")String writer,@Param(value="id")Long id);
}
