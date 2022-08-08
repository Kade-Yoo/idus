package kr.idus.homework.member.controller;

import io.swagger.annotations.ApiImplicitParam;
import kr.idus.homework.member.model.MemberRequest;
import kr.idus.homework.member.model.MemberResponse;
import kr.idus.homework.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<MemberResponse> login(MemberRequest request) {
        return ResponseEntity.ok(memberService.login(request));
    }

    @PostMapping("/join")
    public ResponseEntity<MemberResponse> join(MemberRequest request) {
        return ResponseEntity.ok(memberService.join(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<MemberResponse> logout(MemberRequest request) {
        return ResponseEntity.ok(memberService.logout(request));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MemberResponse>> search(MemberRequest request) {
        return ResponseEntity.ok(memberService.search(request));
    }
}
