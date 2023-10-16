import org.example.config.SpringConfig;
import org.example.dao.trainDao;
import org.example.service.trainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = SpringConfig.class)
public class test {
    @Autowired
    private trainDao T;
    @Autowired
    private trainService TT;
    @Test
    public void select1(){
        System.out.println(T.selectByPageNumber(0));

    }
    @Test
    public void select2(){
        System.out.println(TT.selectAll(0));

    }
}
