package kr.idus.homework.member.service;

import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.member.model.MemberResponse;

import java.util.List;

public interface MemberService {

    MemberResponse join(MemberRequest request);
    MemberResponse getMember(String email);
    List<MemberResponse> search(MemberRequest request);

}
