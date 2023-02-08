package KNU.Navibook.server.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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