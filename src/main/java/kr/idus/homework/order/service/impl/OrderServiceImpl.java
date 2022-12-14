package kr.idus.homework.order.service.impl;

import kr.idus.homework.member.entity.Member;
import kr.idus.homework.order.entity.Order;
import kr.idus.homework.order.model.OrderResponse;
import kr.idus.homework.order.repository.OrderRepository;
import kr.idus.homework.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderResponse> findByMember(String email) {
        return orderRepository.findAllByMember(Member.builder().email(email).build()).stream().map(OrderResponse::of).collect(Collectors.toList());
    }
}
