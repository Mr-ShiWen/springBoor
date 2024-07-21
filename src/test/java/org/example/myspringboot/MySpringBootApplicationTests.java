package org.example.myspringboot;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class MySpringBootApplicationTests {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        //此种方式可通过spring上下文来自动配置一个或多个controller
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        //此种方式，手工指定想要的controller
        //mockMvc = MockMvcBuilders.standaloneSetup(new Controller1(), new Controller2()).build();
    }

    @Test
    public void TestGetAppLatestVersion() throws Exception{
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        RequestBuilder request = null;
        //构造请求
//        request = post("/appProducer/getAppLatestVersion")
//                .param("appId", "1001");
//        //执行请求
//        mockMvc.perform(request)
//                .andExpect(status().isOk())//返回HTTP状态为200
//                .andExpect(jsonPath("$.status", not("E")))//使用jsonPath解析JSON返回值，判断具体的内容, 此处不希望status返回E
//                .andExpect(content().string(containsString("选择浏览器打开即可")))//返回值为字符串，字符串包含比较，也可以字符串相等等比较，content()表示返回的结果
//                .andDo(print());//打印结果
//        //.andReturn();//想要返回结果，使用此方法

        mockMvc.perform(get("/get-str").contentType(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("tr")));
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//                .andExpect(jsonPath("$.status", Matchers.is("success")))
//                .andExpect(jsonPath("$.games[0].name", Matchers.equalToIgnoringCase("zhangsan")));
        System.out.println(status());


    }

    @Test
    void contextLoads() {
    }

}
