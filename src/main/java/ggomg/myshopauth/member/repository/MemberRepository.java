package ggomg.myshopauth.member.repository;

import ggomg.myshopauth.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String memberName);
}
