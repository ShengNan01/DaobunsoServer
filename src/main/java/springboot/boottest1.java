package springboot;

import java.io.Console;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/*@SpringBootApplication將默認對其同package以及其結構下的package進行掃描*/
//@SpringBootApplication(scanBasePackages="可指定主執行程序所在package外的package")
//@ComponentScan("test_springboot") 被默認包含在SpringBootApplication下
//@EnableAutoConfiguration 默認包含在SpringBootApplication下
//@EnableAspectJAutoProxy

//@EnableAutoConfiguration
@SpringBootApplication
public class boottest1 {
	public static void main(String[] args) //1.IOC練習 throws IOException
	{
		//IOC容器 (Inversion of Control 控制反轉)
		ConfigurableApplicationContext run =  SpringApplication.run(boottest1.class, args);
		
		String[] names = run.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name);
		}
		System.out.println("----------------------------------------");
		
		Mixer_interface Anniver2 = run.getBean("Mixer",Mixer_interface.class);
		System.out.println("本次為2周年活動!\n"+Anniver2.mix2());

		
//練習
//		Holo_interface hi1 = run.getBean("Pekora",Holo_interface.class);
//		System.out.println("自我介紹為:\n"+hi1.getFeedback());
//		Holo_interface hi2 = run.getBean("Marine",Holo_interface.class);
//		System.out.println("自我介紹為:\n"+hi2.getFeedback());
//		Holo_interface hi3 = run.getBean("Neol",Holo_interface.class);
//		System.out.println("自我介紹為:\n"+hi3.getFeedback());
		
//1.IOC
//		try (
//				InputStream fis = run.getBean(InputStream.class);
//				OutputStream fos = run.getBean(OutputStream.class);
//				){
//		}.catch{
//		}
			
//2.物件執行
//		Music_interface music_interface = run.getBean("uta1",Music_interface.class);
//		System.out.println("歌名為:"+music_interface.getName()+"\n類型:"+music_interface.getType()
//		+"\n歌手:"+music_interface.getSinger()+"\n製作人:"+music_interface.getProducers());
		
//		用來建立類別的xml組態檔路徑
//		ConfigurableApplicationContext run = new ClassPathXmlApplicationContext();
//		Holo vtubername = run.getBean(Holo.class);
//		System.out.println("自我介紹為:"+ vtubername);
		
//獲取容器內所有定義name > 包含Dispatcher&characterEncodingFilter&ViewResolver&multipartResolver
//		String[]names = run.getBeanDefinitionNames();
//		for (String name : names) {
//			System.out.println(name);
//		}
		//就算有配置文件屬性也會被視為有bean屬性
//		MVC_config bean = run.getBean(MVC_config.class);
//		System.out.print(bean);
		//尋找擁有Holo.class 物件的bean
//		String[] bnt = run.getBeanNamesForType(Holo.class);
//		System.out.println("------------------");
//		for(String s:bnt) {
//			System.out.println(s);
//		}
//		DBHelper dbholor1 = run.getBean(DBHelper.class);
//		System.out.println(dbholor1);
//		
	}
}
