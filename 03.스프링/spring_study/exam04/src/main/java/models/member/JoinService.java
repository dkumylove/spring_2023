package models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService { // 빈의 이름 joinService

    private final MemberDao memberDao; // 상수는 꼭 초기화가 필요하다.
    // 위아래 코드 같은 결과
    @NonNull // 롬복을 만나 코드가 더 간결해짐
    private JoinValidator validator;


    public void join(Member member){
        // 데이터 검증
        validator.validate(member);

        // 데이터 추가
        memberDao.register(member);
    }
}
