package kr.idus.homework.member.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import kr.idus.homework.config.jwt.JwtFilter;
import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.member.model.MemberResponse;
import kr.idus.homework.member.service.MemberAuthService;
import kr.idus.homework.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberAuthService memberAuthService;

    @PostMapping("/login")
    @ApiOperation(value = "회원 로그인", notes = "회원 이메일, 패스워드를 입력하여 로그인")
    public ResponseEntity<String> login(MemberRequest request) {
        String token = memberAuthService.login(request);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + token);

        return new ResponseEntity<>(token, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "회원 로그아웃", notes = "회원 토큰을 clear하여 로그아웃")
    public ResponseEntity<MemberResponse> logout(MemberRequest request) {
        memberAuthService.logout(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/join")
    @ApiOperation(value = "회원가입", notes = "회원 정보를 입력하여 회원가입")
    public ResponseEntity<MemberResponse> join(@RequestBody MemberRequest request) {
        return ResponseEntity.ok(memberService.join(request));
    }

    @PostMapping("/detail")
    @ApiOperation(value = "단일 회원 상세 정보 조회", notes = "회원 이메일을 이용하여 상세 정보 조회")
    public ResponseEntity<MemberResponse> join(@RequestParam("email") String email) {
        return ResponseEntity.ok(memberService.getMember(email));
    }

    @GetMapping("/search")
    @ApiOperation(value = "여러 회원 목록 조회", notes = "회원 이름, 이메일을 이용하여 회원 정보 검색")
    public ResponseEntity<List<MemberResponse>> search(MemberRequest request) {
        return ResponseEntity.ok(memberService.search(request));
    }
}
