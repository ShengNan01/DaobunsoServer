package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication將默認對其同package以及其結構下的package進行掃描
//@SpringBootApplication(scanBasePackages="可指定主執行程序所在package外的package")
//@ComponentScan("test_springboot") 被默認包含在SpringBootApplication下
//@EnableAutoConfiguration 默認包含在SpringBootApplication下

//@EnableAspectJAutoProxy
//@EnableAutoConfiguration
@SpringBootApplication
public class bootMainApp {
	public static void main(String[] args) // 1.IOC練習 throws IOException
	{
		// IOC容器 (Inversion of Control 控制反轉)
		ConfigurableApplicationContext run = SpringApplication.run(bootMainApp.class, args);

//		顯示所有被boot管控的bean
//		String[] names = run.getBeanDefinitionNames();
//		for(String name:names) {
//			System.out.println(name);
//		}
		System.out.println("--------------------------------------------------->伺服器啟動!");

//		
	}
}
