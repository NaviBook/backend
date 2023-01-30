package KNU.Navibook.server.repository;

import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.domain.BookShelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookShelfRepository extends JpaRepository<BookShelf,Long> {

    // 모든 책장 조회
    List<BookShelf> findAll();
    //도서관 층에 있는 모든 책장 조회
    List<BookShelf> findBylibraryFloor(String libraryFloor);

}
