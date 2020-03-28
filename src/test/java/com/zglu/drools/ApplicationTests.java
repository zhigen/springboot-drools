package com.zglu.drools;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author zglu
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationTests {

    @Autowired
    private KieSession kieSession;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(kieSession, "kieSession must not be null!");
        User user = new User();
        kieSession.insert(user);
        int fireAllRulesResult = kieSession.fireAllRules();
        log.info("触发了" + fireAllRulesResult + "条规则");
    }

}
