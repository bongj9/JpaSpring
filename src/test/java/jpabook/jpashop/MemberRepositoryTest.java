package jpabook.jpashop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    /*@Rollback(false)*/
    public void testMember() throws Exception {
        // given
        Member member = new Member(); // 생성자를 만들어주고
        member.setUsername("memberA"); // 값을 넣어주고

        // when
        Long saveId = memberRepository.save(member); // 멤버에 저장해주고
        Member findMember = memberRepository.find(saveId); // 검증은 transaction에서 일어나기 때문에 필요하다

        // then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    }
}
