package KNU.Navibook.server.repository;

import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.Record;
import KNU.Navibook.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Record findByid(Long id);
    List<Record> findBybook(Book book); // Book으로 Record찾기
    List<Record> findByuser(User user);
}