package com.boot.bootlanuch;

import com.boot.bootlanuch.controller.AjaxResponseController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BookControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new AjaxResponseController()).build();  //构造MockMVC
    }

    @Test
    public void saveBook() throws Exception {
        String content = "{\n" +
                "        \"id\": 1,\n" +
                "        \"auto\": \"gcg\",\n" +
                "        \"money\": \"111\",\n" +
                "        \"date\": \"2020-12-12\",\n" +
                "        \"remark\": \"返回书籍信息\",\n" +
                "        \"read\": {\n" +
                "            \"name\": \"GCG\",\n" +
                "            \"age\": \"11\"\n" +
                "        }\n" +
                "    }";
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/book")
                        .contentType("application/json")
                        .content(content.getBytes())
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.read.name").value("GCG"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info("result:" + mvcResult.getResponse().getContentAsString());
    }
}
