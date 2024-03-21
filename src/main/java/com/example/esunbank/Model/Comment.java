package com.example.esunbank.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "comment")
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //指定 ID 的生成方式，自增量
        @Column(name = "id")
        @Getter
        @Setter
        private int id;

        @Getter
        @Setter
        @JsonBackReference
        @JoinColumn(name = "user_id")
        @ManyToOne(cascade = CascadeType.ALL)
        @JsonIgnore
        private User user;

        @Getter
        @Setter
        @JsonBackReference
        @JoinColumn(name = "post_id")
        @ManyToOne(cascade = CascadeType.ALL)
        @JsonIgnore
        private Post post;

        @Getter
        @Setter
        @Column(name = "content")
        private String content;

        @Getter
        @Setter
        @Column(name = "created_at")
        private String created_at;

}
