package kopo.poly.repository;

import kopo.poly.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    /*
    * 모든 테스트 코드는 순서 상관없이 자동으로 아무거나 먼저 실행
    * 테스트가 끝나면 데이터 무조건 클리어 하기 메모리에 이미 올라가서 오류나는 경우가 있음
    * */
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //System.out.println("result = " + (result==member));
        //Assertions.assertEquals(member, result); // 기대값과 결과가 같은지 비교하는 문법
        assertThat(member).isEqualTo(result); // 쉽게 비교하는 방법
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

       List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }



}
