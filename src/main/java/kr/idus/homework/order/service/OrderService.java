package kr.idus.homework.order.service;

import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.order.entity.Order;

public interface OrderService {

    Order findByMember(MemberRequest request);
}
