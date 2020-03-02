package com.cisco.demoproject.softwares.pojo;


import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class SoftwaresTest {
    @Test
    public void queueMessageGetterAndSetterCorrectness() {
        new BeanTester().testBean(Softwares.class);
       // new BeanTester().testBean(EventDetails.class);
    }
}
