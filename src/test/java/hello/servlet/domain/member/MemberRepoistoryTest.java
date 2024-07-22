package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepoistoryTest {

    MemberRepository memberRepoistory = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepoistory.clearStore();
    }
    @DisplayName("저장 테스트")
    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepoistory.save(member);
        //then
        Member findMember = memberRepoistory.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }
    @DisplayName("리스트 출력")
    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepoistory.save(member1);
        memberRepoistory.save(member2);
        //when
        List<Member> result = memberRepoistory.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

}