package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberDao memberDao;

    public void join(RequestJoin form) {

        // BCrypt 유동 해시 : 같은 값에 대해서 해시를 만들때 마다 다른 해시값/ 예측 불가능성
        // 12 : 12회 반복
        String hash = BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt(12));

        // 암호화 사용
        // .userPw(form.getUserPw()) => .userPw(hash)
        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(hash)
                .userNm(form.getUserNm())
                .email(form.getEmail())
                .build();

        memberDao.register(member);
    }
}