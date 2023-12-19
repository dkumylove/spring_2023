package controllers.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
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
    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("자바", "오라클", "JSP", "스프링");
    }

    // 회원가입 정보를 받아 model에 저장
    @GetMapping("/join") // = /member/join
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path="/member/join")
    public String join(@ModelAttribute RequestJoin from, Model model) {
        // @ModelAttribute RequestJoin from : 비어있는 객체라도 보여주기위해 생성
        // Model = 데이터 : 스프링 인터페이스

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

    // 검증 후 회원가입처리
    @PostMapping("/join")  // = /member/join
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model) {
        // @Valid : 들어오는 값에 대한 검증을 할수 있다.

        joinValidator.validate(form, errors);

        // 검증실패시 다리 회원가입 페이지로 이동
        if(errors.hasErrors()){ // 검증 실패시 - 참 도출
            return  "member/join";
        }

        // 회원 가입 처리
        joinService.join(form);

        //System.out.println(form);
        // 커맨드객체 RequestJoin -> requestJoin 이름으로 속성이 추가 ->
        // 템플릿 내에서 바로 접근 가능

        //model.addAttribute("requestJoin",form);

        // 처리후 로그인페인지로 이동
        // redirect:/member/join = response.sendRededirect(request.getContextPath() + "/member/join")
        // 응답해더 Location쪽에 주소(/member/join)가 추가 되는
        //return "member/join"; // response.sendRedirect(...) location: 주소
        return "redirect:/member/login"; // 302 -> get 주소 -> 브라우저 히스토리
        //return "forward:/member/login"; // 페이지이동이 아니고 출력버퍼가 바뀜
    }

    @GetMapping("/login")  // = /member/login
    public String login(@ModelAttribute RequestLogin form) {

        System.out.println(form);

        return "member/login";
    }

    @PostMapping("/login") // = /member/login
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        // 회원정보 일치여부 확인
        loginValidator.validate(form, errors);
        System.out.println("===== form : " + form);

        if(errors.hasErrors()){ // 검증 실패시 - 참 도출
            return  "member/login";
        }

        // 로그인 처리 / 정보 세션에 저장
        loginService.login(form);

        //return "member/login";
        return "redirect:/"; // 로그인 성공시 메인페이지 이동
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

    /*
    // MemberController해당하는 공통 Validator
    @InitBinder // @Controller나 @ControllerAdvice가 붙은 클래스는 @InitBinder가 붙은 메소드를 가질 수 있다. 이는 WebDataBinder라는 인스턴스를 초기화하는 메소드
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }*/

}
