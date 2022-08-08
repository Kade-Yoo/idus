package kr.idus.homework.order.entity;

import kr.idus.homework.member.entity.Member;
import kr.idus.homework.product.entity.Product;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "ORDER")
public class Order {

    @Id
    private Long id;
    private String orderNo;

    @ManyToOne(targetEntity = Product.class ,fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    private Member member;
    private LocalDateTime orderDate;
}
