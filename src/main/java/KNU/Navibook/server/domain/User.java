package KNU.Navibook.server.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User{

    @Id
    @Column(name="USER_ID")
    private String id;
    private String user_name;
    private String pw;
    private String admin;
    private String sign_date;

    @OneToMany(mappedBy = "user")
    private List<Record> record = new ArrayList<>();

}