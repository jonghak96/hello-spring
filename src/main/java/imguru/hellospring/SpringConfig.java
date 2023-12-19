package imguru.hellospring;

import imguru.hellospring.aop.TimeTraceAop;
import imguru.hellospring.repository.JdbcTemplateMemberRepository;
import imguru.hellospring.repository.JpaMemberRepository;
import imguru.hellospring.repository.MemberRepository;
import imguru.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*
    * JDBC (Java DataBase Connection) dataSource 파라미터로 넘겨주는 작업
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */

    /*
    * JPA (Java Persistence API) EntityManager 파라미터로 넘겨주는 작업
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
     */

    /*
    * SPRING DATA JPA
     */
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository); // SPRING DATA JPA
    }

    /*
    * SPRING DATA JPA
    * interface 만 있으면
    * Spring Data JPA 가 (org.springframework.data.jpa 가 제공 하는) JpaRepository 를 받고 있으면
    * 구현체를 자동으로 만들어 줘요.
    * 그래서 Spring Bean 을 자동으로 등록 해요.
    * => 파라미터 넘길 필요 없음.
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);

    }
     */

    /*
    * @Component 스캔을 써도 되고, @Bean 직접 등록 해줘도 됨.
    @Bean
    public TimeTraceAop TimeTraceAop() {
        return new TimeTraceAop();
    }
     */

}
