import org.example1.config.SpringConfig;
import org.example1.dao.testDaoFA;
import org.example1.service.testServiceFA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testForAnnotation {
    public static void main(String[] args) {
        ApplicationContext tacfa=new AnnotationConfigApplicationContext(SpringConfig.class);

        testDaoFA testDao=tacfa.getBean(testDaoFA.class);
        testDao.a();
        testServiceFA testService=(testServiceFA) tacfa.getBean("testServiceFA");
        testService.b();
    }
}
