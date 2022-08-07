package kr.idus.homework.product.entity;

import kr.idus.homework.order.entity.Order;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Product {

    @Id
    private Long id;
    private String productNo;
    private String productNm;
    @OneToMany(mappedBy = "product")
    private List<Order> orderList;
}
