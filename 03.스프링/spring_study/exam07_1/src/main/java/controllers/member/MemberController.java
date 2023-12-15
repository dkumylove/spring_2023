package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor   // 생성자를 자동으로 생성, final로 지정된 필드에 대해 생성자 생성
public class MemberController {

    private final JoinValidator joinValidator;

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("자바", "오라클", "JSP", "스프링");
    }

    @GetMapping("/join") // = /member/join
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path="/member/join")
    public String join(@ModelAttribute RequestJoin from, Model model) {

        /*String[] addCss = {"member/style1", "member/style2"};
        List<String> addScript = Arrays.asList("member/script1", "member/script2");

        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);*/
        model.addAttribute("pageTitle", "회원가입");
        // 겟방식일때는 데이터를 담아오지 않기 떄문에 유지되지 않음, 비어있는 것이라도 나와야 할때 새롭게 정의해서 넣음
        //model.addAttribute("requestJoin", new RequestJoin());
        //@ModelAttribute RequestJoin from 같은 역학을함

        /*
        Member member = Member.builder()
                .userNo(1L)
                .userPw("1234")
                .userId("user01")
                .userNm("<h1>사용자01</h1>")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .build();

        model.addAttribute("member", member);
        model.addAttribute("pageTitle", "회원가입");
        */

        return "/member/join";
    }

    @PostMapping("/join")  // = /member/join
    public String joinPs(RequestJoin form, Errors errors, Model model) {

        joinValidator.validate(form, errors);

        if(errors.hasErrors()){ // 검증 실패시 - 참 도출
            return  "member/join";
        }

        //System.out.println(form);
        // 커맨드객체 RequestJoin -> requestJoin 이름으로 속성이 추가 ->
        // 템플릿 내에서 바로 접근 가능

        //model.addAttribute("requestJoin",form);

        // redirect:/member/join = response.sendRededirect(request.getContextPath() + "/member/join")
        // 응답해더 Location쪽에 주소(/member/join)가 추가 되는
        //return "member/join"; // response.sendRedirect(...) location: 주소
        //return "redirect:/member/login"; // 302 -> get 주소 -> 브라우저 히스토리
        return "forward:/member/login"; // 페이지이동이 아니고 출력버퍼가 바뀜
    }

    @GetMapping("/login")  // = /member/login
    public String login() {

        return "member/login";
    }

    @PostMapping("/login") // = /member/login
    public String loginPs(RequestLogin form) {

        System.out.println("===== form : " + form);

        return "member/login";
    }

    @GetMapping("/list")  // = /member/list
    public String members(Model model) {

        List<Member> members = new ArrayList<>();
        for(int i = 1; i <=10; i++){
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userPw("1234")
                    .userId("user" + i)
                    .userNm("사용자" + i)
                    .email("user" + i + "@test.org")
                    .regDt(LocalDateTime.now())
                    .build();
            members.add(member);
        }
        model.addAttribute("members", members);

        return  "member/list";
    }
}
