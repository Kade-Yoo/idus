package kr.idus.homework.member.service.impl;

import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.member.model.MemberResponse;
import kr.idus.homework.member.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Override
    public MemberResponse join(MemberRequest memberRequest) {
        return null;
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
        return null;
    }
}
