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
    @JoinTable( // JoinTable은 테이블과 테이블 사이에 별도의 조인 테이블을 만들어 양 테이블간의 연관관계를 설정 하는 방법
            name = "account_authority",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    public Member() {}

    @Builder
    public Member(String name, String nickname, String password, String email, String phone, String sex) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.email = email;
    }
}
