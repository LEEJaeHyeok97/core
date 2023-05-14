package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        System.out.println("================");
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinitionName.contains("memberService")) {
                if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                    System.out.println("beanDefinitionName : " + beanDefinitionName +
                            " beanDefinition : " + beanDefinition);
                }
            }

        }
        System.out.println("================");

//        MemberService memberService = ac.getBean(MemberService.class);
//        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
