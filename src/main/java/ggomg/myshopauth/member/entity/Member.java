package ggomg.myshopauth.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "password")
    private String encodedPassword;

    private Member(String name, String password) {
        this.name = name;
        this.encodedPassword = password;
    }

    public static Member createMember(String name, String password) {
        return new Member(name, password);
    }
}