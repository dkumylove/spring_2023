package controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMemberController")  // 스프링은 빈의 이름을 클래스 명으로 사용하기 때문에 같은이름은 충동발생
@RequestMapping("/admin/member")
public class MemberController {

    @GetMapping   // /admin/member 호출됨
    public  String index() {


        return "admin/member/list";
    }
}
