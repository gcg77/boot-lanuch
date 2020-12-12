package com.boot.bootlanuch;

import com.boot.bootlanuch.controller.AjaxResponseController;
import com.boot.bootlanuch.model.book.BooksInfo;
import com.boot.bootlanuch.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest()
@WebAppConfiguration
public class BookControllerTest3 {
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;
    @Autowired
    private AjaxResponseController ajaxResponseController;
    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(ajaxResponseController).build();  //构造MockMVC
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
        ObjectMapper objectMapper=new ObjectMapper();
        BooksInfo booksInfo=objectMapper.readValue(content,BooksInfo.class);
        when(bookService.saveBook(booksInfo)).thenReturn("ok");
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/book")
                        .contentType("application/json")
                        .content(content.getBytes())
        )
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok"))
                /*.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.read.name").value("GCG"))*/
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info("result:" + mvcResult.getResponse().getContentAsString());
    }
}
