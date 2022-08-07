package kr.idus.homework.member.service.impl;

import kr.idus.homework.member.entity.Member;
import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.member.model.MemberResponse;
import kr.idus.homework.member.repository.MemberRepository;
import kr.idus.homework.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberResponse join(MemberRequest memberRequest) {
        Member member = memberRepository.save(MemberRequest.of(memberRequest));
        return MemberResponse.of(member);
    }

    @Override
    public MemberResponse login(MemberRequest memberRequest) {
        return null;
    }

    @Override
    public MemberResponse logout(MemberRequest memberRequest) {
        return null;
    }

    @Override
    public List<MemberResponse> search(MemberRequest request) {
        List<Member> members = memberRepository.findAllByNameOrEmail(request.getName(), request.getEmail());
        return members.stream().map(MemberResponse::of).collect(Collectors.toList());
    }
}
