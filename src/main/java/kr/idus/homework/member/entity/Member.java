package kr.idus.homework.member.entity;

import kr.idus.homework.order.entity.Order;
import kr.idus.homework.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

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

    @ManyToOne(targetEntity = Product.class,fetch = FetchType.LAZY)
    private Order order;

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
