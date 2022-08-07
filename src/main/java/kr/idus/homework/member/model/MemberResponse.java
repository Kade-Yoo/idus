package kr.idus.homework.member.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.idus.homework.member.entity.Member;
import lombok.Builder;

@ApiModel(value = "회원 정보")
public class MemberResponse {

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

    public MemberResponse() {}

    @Builder
    public MemberResponse(String name, String nickname, String password, String phone, String email, String sex) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
    }

    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
                .email(member.getEmail())
                .name(member.getName())
                .nickname(member.getNickname())
                .password(member.getPassword())
                .sex(member.getSex())
                .build();
    }
}
