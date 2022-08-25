package kopo.poly.SpringConfig;

import kopo.poly.aop.TimeTraceAop;
import kopo.poly.repository.MemberRepository;
import kopo.poly.repository.MemoryMemberRepository;
import kopo.poly.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
