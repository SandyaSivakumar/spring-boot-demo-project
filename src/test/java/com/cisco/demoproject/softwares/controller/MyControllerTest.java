package com.cisco.demoproject.softwares.controller;

import com.cisco.demoproject.softwares.SoftwaresApplication;
import com.cisco.demoproject.softwares.pojo.Softwares;
import com.cisco.demoproject.softwares.service.SoftwareService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SoftwaresApplication.class)
@WebAppConfiguration
public class MyControllerTest {

    protected MockMvc mvc;

    SoftwareService softwareService;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Before

    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        softwareService = Mockito.mock(SoftwareService.class);
    }

    @Test
    public void test() throws Exception{
        Softwares softwares = new Softwares();
        softwares.setViews(63);
        softwares.setApplication("CD Data Plane");
        softwares.setCreatedDate("03/02/2020");
        softwares.setLanguageUsed("Java");
        softwares.setLinesOfCode(3200);
        softwares.setOwner("owner");
        softwares.setService("serviceOwner");
        softwares.setService("service");
        softwares.setSoftwareId("softwareId");
        softwares.setSoftwareName("softwareName");
        //test1
        String data = "{\"softwareId\":\"CD001\",\"softwareName\":\"cdapi-cd-code-security-data-api\",\"languageUsed\":\"Java\",\"createdDate\":\"03/02/2020\",\"owner\":\"Yashika\",\"application\":\"CD Data Plane\",\"linesOfCode\":3200,\"service\":\"Continuous Delivery Systems\",\"serviceOwner\":\"Jyoti Sarin\",\"views\":81}";
        String uri = "/softwares/CD001";
        Mockito.when(softwareService.findObject("test")).thenReturn(softwares);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        assertEquals(mvcResult.getResponse().getContentAsString(),data);
        //System.out.println(mvcResult.getResponse().getContentAsString());


    }
    @Test
    public void test2() throws Exception{
        //test2
        ArrayList<Softwares> softwares = new ArrayList<Softwares>();
        Softwares software1 = new Softwares();
        software1.setViews(63);
        software1.setApplication("CD Data Plane");
        software1.setCreatedDate("03/02/2020");
        software1.setLanguageUsed("Java");
        software1.setLinesOfCode(3200);
        software1.setOwner("owner");
        software1.setService("serviceOwner");
        software1.setService("service");
        software1.setSoftwareId("softwareId");
        software1.setSoftwareName("softwareName");
        softwares.add(software1);
        //System.out.println(softwares);

        String data = "[{\"softwareId\":\"CD001\",\"softwareName\":\"cdapi-cd-code-security-data-api\",\"languageUsed\":\"Java\",\"createdDate\":\"03/02/2020\",\"owner\":\"Yashika\",\"application\":\"CD Data Plane\",\"linesOfCode\":3200,\"service\":\"Continuous Delivery Systems\",\"serviceOwner\":\"Jyoti Sarin\",\"views\":81}]";
        String uri = "/software/cdapi-cd-code-security-data-api";
        Mockito.when(softwareService.findByName("cdapi-cd-code-security-data-api")).thenReturn((List<Softwares>)softwares);
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        assertEquals(mvcResult.getResponse().getContentAsString(),data);
    }

    @Test
    public void test3() throws Exception{
        //test3

    }
}

