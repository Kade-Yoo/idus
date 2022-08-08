package kr.idus.homework.member.service.impl;

import kr.idus.homework.authority.entity.Authority;
import kr.idus.homework.member.entity.Member;
import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.member.model.MemberResponse;
import kr.idus.homework.member.repository.MemberRepository;
import kr.idus.homework.member.service.MemberService;
import kr.idus.homework.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final OrderService orderService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberResponse join(MemberRequest memberRequest) {
        Optional<Member> memberOptional = memberRepository.findByEmail(memberRequest.getEmail());
        if (memberOptional.isPresent()) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder().authorityName("ROLE_USER").build();
        Member member = Member.builder()
                .name(memberRequest.getName())
                .email(memberRequest.getEmail())
                .password(passwordEncoder.encode(memberRequest.getPassword()))
                .nickname(memberRequest.getNickname())
                .authorities(Collections.singleton(authority))
                .build();

        return MemberResponse.of(memberRepository.save(member));
    }

    @Override
    public MemberResponse getMember(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("조회된 회원 정보가 없습니다."));
        return MemberResponse.of(member);
    }

    @Override
    public List<MemberResponse> search(MemberRequest request) {
        List<Member> members = memberRepository.findAllByNameOrEmail(request.getName(), request.getEmail());
        return members.stream().map(MemberResponse::of).collect(Collectors.toList());
    }
}
