package com.example.esunbank.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //指定 ID 的生成方式，自增量
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    @Column(name = "username", unique = true)
    private String username;

    @Getter
    @Setter
    @Column(name = "phone", unique = true)
    private String phone;

    @Getter
    @Setter
    @Column(name = "email", unique = true)
    private String email;


    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @Column(name = "salt")
    private String salt;

    @Getter
    @Setter
    @Column(name = "image")
    private String image;

    @Getter
    @Setter
    @Column(name = "biography")
    private String biography;


    @JsonManagedReference // 父級角色
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @EqualsAndHashCode.Exclude //排除特定的字段
    private List<Post> postlist;

}
