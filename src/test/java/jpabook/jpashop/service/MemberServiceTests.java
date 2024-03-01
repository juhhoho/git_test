package jpabook.jpashop.service;

import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional

public class MemberServiceTests {
    @Autowired MemberService memberService;
    
    @Test
    public void creaetMemberTest(){
        Member member = new Member();
        member.setMid("user1");
        member.setMpw("1111");
        member.setEmail("qwe@asd.com");
        Member createMember = memberService.create(member.getMid(), member.getMpw(), member.getEmail());
        
        if(member.getMid().equals(createMember.getMid())){
            System.out.println("createMember.getMid() = " + createMember.getMid());
        }
    }
    
}
