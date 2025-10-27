package hello.hello_spring.service;

// import java.util.List;
// import java.util.Optional;

import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository =  new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    
    @Test
    public void 회원가입테스트(){
        Member member = new Member();
        member.setName("test");
        Long id = memberService.join(member);

        Member joinedMember = memberService.findOne(id).get();

        assertThat(joinedMember).isEqualTo(member.getName());
    }
    @Test
    //중복 확인
    public void 중복테스트(){
        Member member1 = new Member();
        member1.setName("test1");

        Member member2 = new Member();
        member2.setName("test1");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("duplicateed");
    }
}
