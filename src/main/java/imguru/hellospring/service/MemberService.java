package imguru.hellospring.service;

import imguru.hellospring.domain.Member;
import imguru.hellospring.repository.MemberRepository;
import imguru.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /** 회원 가입 */
    public Long join(Member member) {
        // 이름 중복 불가 X
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /** 중복 회원 검증 */
    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        /*
            Optional<Member> result = memberRepository.findByName(member.getName());
            result.ifPresent(member1 -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
        */
    }

    /** 전체 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);

    }
}
