package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    
    @Test
    public void save(){
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);
        Member result = repository.findById(member1.getId()).get();
        assertEquals(result,member1);
    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);
        
        Member result1 = repository.findById(member1.getId()).get();
        assertEquals(result1,member1);

        Member result2 = repository.findById(member2.getId()).get();
        assertEquals(result2,member2);
    }

    
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);
        
        Member result1 = repository.findByName(member1.getName()).get();
        assertEquals(result1,member1);

        Member result2 = repository.findByName(member2.getName()).get();
        assertEquals(result2,member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);
        
        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}