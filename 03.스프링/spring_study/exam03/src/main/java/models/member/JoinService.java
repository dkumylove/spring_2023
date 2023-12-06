package models.member;

import org.springframework.beans.factory.annotation.Autowired;

public class JoinService {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private JoinValidator validator;

    // 기본생성자
    public JoinService() {}

    // 생성자를 통한 주입
    public JoinService(MemberDao memberDao, JoinValidator validator){
        this.memberDao = memberDao;
        this.validator = validator;
    }

    public void join(Member member){
        // 데이터 검증
        validator.validate(member);

        // 데이터 추가
        memberDao.register(member);
    }
}
