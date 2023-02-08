package KNU.Navibook.server.repository;

import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Record findByid(Long id);
    Record findBybook(Book book); // Book으로 Record찾기
}