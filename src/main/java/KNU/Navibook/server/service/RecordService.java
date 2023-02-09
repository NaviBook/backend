package KNU.Navibook.server.service;

import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.Record;
import KNU.Navibook.server.domain.User;
import KNU.Navibook.server.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    public List<Record> findRecords(){
        return recordRepository.findAll();
    } // 모든 Record 찾기
    public List<Record> findRecordByBook(Book book) { return recordRepository.findBybook(book);} // 책으로 Record 찾기
    public List<Record> findRecordByUser(User user) { return recordRepository.findByuser(user);} // 유저로 Record 찾기
    public Record saveRecord(Record record){
        return recordRepository.save(record);
    }

}
