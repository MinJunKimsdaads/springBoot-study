package hello.hello_spring.service;

import java.util.List;
import java.util.Optional;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    

    //회원 가입
    public Long join(Member member){
        validateDuplicateMember(member); //중복 확인
        memberRepository.save(member);
        return member.getId();
    }

    //중복 확인
    public void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("duplicateed");
            });
    }

    //회원 전체 조회
    public List<Member> finMembers(){
        return memberRepository.findAll();
    }

    //특정 회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    
}
