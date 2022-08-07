package kr.idus.homework.order.service;

import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.order.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findByMember(String email);
}
