package kr.idus.homework.member.entity;

import kr.idus.homework.authority.entity.Authority;
import kr.idus.homework.order.entity.Order;
import kr.idus.homework.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
public class Member {

    @Id
    private Long id;
    private String name;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private String sex;

    @OneToMany(mappedBy = "member")
    private List<Order> orderList;

    @ManyToMany
    @JoinTable(name = "authorities", joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    public Member() {}

    @Builder
    public Member(String name, String nickname, String password, String email, String phone, String sex, Set<Authority> authorities) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.email = email;
        this.authorities = authorities;
    }
}
