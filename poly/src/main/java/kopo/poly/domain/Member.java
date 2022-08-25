package kopo.poly.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //db에서 자동으로 생성성
   private Long id;

    @Column(name = "username") // DB 컬럼명이랑 자동으로 매핑핑
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
