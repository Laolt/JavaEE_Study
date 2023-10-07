import org.example.config.SpringConfig;
import org.example.dao.testDaoFA;
import org.example.service.testServiceFA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testForAnnotation {
    public static void main(String[] args) {
        ApplicationContext tacfa=new AnnotationConfigApplicationContext(SpringConfig.class);

        testDaoFA testDao=tacfa.getBean(testDaoFA.class);
        testDao.a();
        testServiceFA testService=tacfa.getBean(testServiceFA.class);
        testService.b();
    }
}
