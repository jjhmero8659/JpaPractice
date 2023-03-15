package jpa.jpashop.service;

import jpa.jpashop.domain.Member;
import jpa.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public Long joinMember(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    public Member findMember(Long id){
        return memberRepository.findOne(id);
    }

    public List<Member> findAllMember(){
        return memberRepository.findAll();
    }
}
