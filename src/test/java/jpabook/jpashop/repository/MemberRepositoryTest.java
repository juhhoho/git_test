package jpabook.jpashop.repository;

import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
@Transactional
public class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @Test
    @Rollback(value = false)
    public void 저장() throws Exception{
        for(int i=0;i<10;i++){
            Member member = new Member();
            member.setMid("user" + (i+1));
            member.setMpw(passwordEncoder.encode("asd"));
            member.setEmail("qwe12");

            memberRepository.save(member);
        }
    }
    @Test
    public void findMemberById() throws Exception{
        Long id = 1l;
        Optional<Member> one = memberRepository.findById(id);
        one.ifPresent(member -> {
            System.out.println("member = " + member.getMid());
        });


    }

    @Test
    public void findMemberList(){
        List<Member> members = memberRepository.findAll();
        int cnt = 1;
        for(Member member: members){
            System.out.println("member" + cnt + ": " + member.getMid());
            cnt++;
        }
    }
}
