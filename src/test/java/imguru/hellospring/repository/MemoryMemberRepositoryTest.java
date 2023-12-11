package imguru.hellospring.repository;

import imguru.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Lee");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        System.out.println("result :: " + (result == member));
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Wak1");
        repository.save(member1);

        Member name2 = new Member();
        name2.setName("Wak2");
        repository.save(name2);

        Member result = repository.findByName("Wak1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Wak1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Wak2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("Wak3");
        repository.save(member3);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(4);
    }
}
