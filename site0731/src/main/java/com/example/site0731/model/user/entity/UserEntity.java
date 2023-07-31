package com.example.site0731.model.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "`user`")
@AllArgsConstructor //3가지 매개변수를 받는 생성자를 생성해주겠다
@NoArgsConstructor
@Getter
@ToString
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", nullable = false, unique = true)
    private Long idx;

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "password", nullable = false) //Column에 있는게 DB에 있는 이름
    private String password; //private로 선언한게 자바에 있는 이름
}
