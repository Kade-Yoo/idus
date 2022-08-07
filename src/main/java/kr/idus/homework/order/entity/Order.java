package kr.idus.homework.order.entity;

import kr.idus.homework.member.entity.Member;
import kr.idus.homework.product.entity.Product;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    private Long id;
    private String orderNo;

    @ManyToOne(targetEntity = Product.class,fetch = FetchType.LAZY)
    private Product product;

    @OneToMany(mappedBy = "order")
    private List<Member> member;
    private LocalDateTime orderDate;
}
