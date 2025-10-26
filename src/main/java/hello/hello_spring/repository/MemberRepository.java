package hello.hello_spring.repository;
import java.util.List;

import hello.hello_spring.domain.Member;

import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    
}