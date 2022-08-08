package kr.idus.homework.member.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.idus.homework.member.entity.Member;
import lombok.Getter;

@Getter
@ApiModel(value = "회원 정보")
public class MemberRequest {

    @ApiModelProperty(name = "회원 이름", dataType = "String", value = "유형민")
    private String name;
    @ApiModelProperty(name = "회원 별명", dataType = "String", value = "가나다")
    private String nickname;
    @ApiModelProperty(name = "비밀번호", dataType = "String", value = "**")
    private String password;
    @ApiModelProperty(name = "핸드폰 번호", dataType = "String", value = "010-1234-1234")
    private String phone;
    @ApiModelProperty(name = "이메일", dataType = "String", value = "****@naver.com")
    private String email;
    @ApiModelProperty(name = "성별", dataType = "String", value = "MAEL")
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
