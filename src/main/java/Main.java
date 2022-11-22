import com.progress.AutowiredExample;
import com.progress.HelloBean;
import com.progress.ResourseExample;
import com.progress.Student;
import com.progress.TransferService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloBean bean = (HelloBean) context.getBean("helloWorld");
        System.out.println(bean.getMessage());

        Student student = (Student) context.getBean("student");
        System.out.println("Name : " + student.getName() );
        System.out.println("Age : " + student.getAge() );



        //Through Java configuration
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        TransferService service = (TransferService) ctx.getBean("standardTransferService");
        HelloBean bean1 = (HelloBean) ctx.getBean("helloBean");
        ResourseExample resourseExample = (ResourseExample) ctx.getBean("resourseExample");
        System.out.println("From Resourse="+resourseExample.getHelloBean().getMessage());

        System.out.println(bean1.getMessage());
        System.out.println(bean1.getMessageValue());
        System.out.println(service.transfer(43));

        for (String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        AutowiredExample example = (AutowiredExample) ctx.getBean(AutowiredExample.class);
        System.out.println(example.getMessage());
        BeanDefinitionRegistry factory =
                (BeanDefinitionRegistry) ctx.getAutowireCapableBeanFactory();
        factory.removeBeanDefinition("helloBean");
    }
}
