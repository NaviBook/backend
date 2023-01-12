package KNU.Navibook.server.domain;

import jakarta.persistence.*;

import java.awt.print.Book;

@Entity
public class Record{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long record_id;
    @ManyToOne // 1
    @JoinColumn(name = "USER_ID") // 2
    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "book_id")
//    private Book book_id;

    private String give_date;
    private String take_date;

    public String getGive_date() {
        return give_date;
    }

    public void setGive_date(String give_date) {
        this.give_date = give_date;
    }

    public String getTake_date() {
        return take_date;
    }

    public void setTake_date(String take_date) {
        this.take_date = take_date;
    }
}
