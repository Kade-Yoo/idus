package kr.idus.homework.member.model;

import kr.idus.homework.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberRequest {

    private String name;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private String sex;

    public static Member of(MemberRequest request) {
        return Member.builder()
                .name(request.name)
                .email(request.email)
                .nickname(request.nickname)
                .sex(request.sex)
                .password(request.password)
                .phone(request.phone)
                .build();
    }
}
