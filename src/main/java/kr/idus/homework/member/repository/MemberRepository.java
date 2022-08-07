package kr.idus.homework.member.repository;

import kr.idus.homework.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByNameOrEmail(String name, String email);
}
