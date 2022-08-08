package kr.idus.homework.order.controller;

import io.swagger.annotations.ApiOperation;
import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.member.model.MemberResponse;
import kr.idus.homework.order.entity.Order;
import kr.idus.homework.order.model.OrderResponse;
import kr.idus.homework.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{email}")
    @ApiOperation(value = "단일 회원의 주문 목록 조회", notes = "회원 이메일을 이용하여 주문정보 조회")
    public ResponseEntity<List<OrderResponse>> getOrderByMember(@PathVariable("email") String email) {
        return ResponseEntity.ok(orderService.findByMember(email));
    }
}
