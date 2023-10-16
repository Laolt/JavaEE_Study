import org.example.config.SpringConfig;
import org.example.dao.trainDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test1 {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        trainDao dao=context.getBean(trainDao.class);
        System.out.println(dao.selectByPageNumber(0));
    }
}
