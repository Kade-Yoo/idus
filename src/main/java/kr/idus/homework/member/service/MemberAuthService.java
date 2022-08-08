package kr.idus.homework.member.service;

import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.member.model.MemberResponse;

public interface MemberAuthService {

    String login(MemberRequest memberRequest);
    void logout(MemberRequest memberRequest);
}
