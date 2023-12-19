package imguru.hellospring.repository;


import imguru.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // method 이름 만으로 조회 기능 제공 (+페이징)
    // JPQL (Java Persistence Query Language) : SELECT m FROM Member AS m WHERE m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
