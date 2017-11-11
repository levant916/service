package hello.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsoupBOTest {
    @Autowired
    JsoupBO jsoupBO;
    private static final String baseUrl2 = "http://finance.naver.com/item/sise_time.nhn";
    @Test
    public void getDataPerTime() throws Exception {
        jsoupBO.getDataPerTime("000660", 41);
    }

    @Test
    public void getDataPerDate() throws Exception {
        jsoupBO.getDataPerDate("006380", 1);
    }
}