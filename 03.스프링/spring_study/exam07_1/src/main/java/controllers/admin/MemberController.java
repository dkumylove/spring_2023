package controllers.admin;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("adminMemberController")  // 스프링은 빈의 이름을 클래스 명으로 사용하기 때문에 같은이름은 충동발생
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberDao memberDao;

    @GetMapping   // /admin/member 호출됨
    public  String index(@ModelAttribute MemberSearch search, Errors errors, Model model) {

        List<Member> members = memberDao.getList(search);
        model.addAttribute("members", members);

        return "admin/member/list";
    }

    // /admin/member/회원아이디
    @GetMapping("/{id}")
    public String info(@PathVariable("id") String userId) {

        System.out.println(userId);
        return "admin/member/info";
    }
}
