package jpabook.jpashop;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() throws Exception{
        //given
        Member member = new Member();//생성자를 만들어주고
        member.setUsername("memberA");//값을 넣어주고
        // when
        Long saveId = memberRepository.save(member);//멤버에 저장해주고
        Member findMember = memberRepository.find(saveId); //검증은 transction에서 일어나기때문에 필요하다
        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());


    }
}