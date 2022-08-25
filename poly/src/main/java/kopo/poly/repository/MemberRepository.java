package kopo.poly.repository;

import kopo.poly.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id); //데이터를 가져왔을때 null 처리 하는 방법

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
