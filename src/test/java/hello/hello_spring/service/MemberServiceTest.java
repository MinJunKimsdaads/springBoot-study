package hello.hello_spring.service;

// import java.util.List;
// import java.util.Optional;

import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import hello.hello_spring.domain.Member;

public class MemberServiceTest {
    MemberService memberService = new MemberService();
    
    @Test
    public void 회원가입테스트(){
        Member member = new Member();
        member.setName("test");
        Long id = memberService.join(member);

        Member joinedMember = memberService.findOne(id).get();

        assertThat(joinedMember).isEqualTo(member.getName());
    }
    // @Test
    // //중복 확인
    // public void validateDuplicateMember(Member member){
    //     memberRepository.findByName(member.getName())
    //         .ifPresent(m -> {
    //             throw new IllegalStateException("duplicateed");
    //         });
    // }
    // @Test
    // //회원 전체 조회
    // public List<Member> finMembers(){
    //     return memberRepository.findAll();
    // }
    // @Test
    // //특정 회원 조회
    // public Optional<Member> findOne(Long memberId){
    //     return memberRepository.findById(memberId);
    // }
}
