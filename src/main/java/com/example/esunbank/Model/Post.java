package com.example.esunbank.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "post")

public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //指定 ID 的生成方式，自增量
        @Column(name = "id")
        @Getter
        @Setter
        private Integer id;

        @Getter
        @Setter
        @JsonBackReference
        @JoinColumn(name = "user_id")
        @ManyToOne(cascade = CascadeType.ALL)
        private User user;

        @Getter
        @Setter
        @Column(name = "content")
        private String content;

        @Getter
        @Setter
        @Column(name = "image")
        private String image;

        @Getter
        @Setter
        @Column(name = "created_at")
        private String created_at;


}
