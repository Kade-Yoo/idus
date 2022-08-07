package kr.idus.homework.order.repository;

import kr.idus.homework.member.entity.Member;
import kr.idus.homework.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByMember(Member member);
}
