package KNU.Navibook.server.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User{

    @Id
    @Column(name="USER_ID")
    private String id;
    private String pw;
    private String name;
    private Boolean admin;

//    @OneToMany(mappedBy = "user")
//    private List<Record> record = new ArrayList<>();

}