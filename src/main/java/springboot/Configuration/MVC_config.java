package springboot.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springboot.Games;
import springboot.Games_interface;
import springboot.Holo;
import springboot.Holo_interface;
import springboot.Mixer;
import springboot.Mixer_interface;

/*
Configuration配置文件

proxyBeanMethods代理方法(boot預設為true)
Full(proxyBeanMethods=true)singleton
Lite(proxyBeanMethods=false)prototype
request 不同請求獲取不同物件，同一個請求獲取同一物件

如果proxyBeanMethods代理方法 = true，那外部不管對配置中的物件調用多少次皆為相同內容，
代表物件具有唯一性與實例，可讓兩種物件產生依賴關係。
@Configuration(proxyBeanMethods = true)
@Import({User.class,DBHelper.class})給容器自動創建出這兩個類別

*
*
*/

//@Import({Holo.class,Games.class,Music.class})
//@PropertySource("MCV_config.properties")//psrc指定properties檔案路徑
//@EnableConfigurationProperties(Games.class)//開啟配置綁定，讓組件自動配置到容器中
//@EnableConfigurationProperties(Music.class)
@EnableTransactionManagement//可執行交易
@ComponentScan
//@EnableWebMvc
@Configuration
public class MVC_config {
	
//共同使用變數 不建議
	Games_interface game_m = new Games("Mincraft", "Creative", true, 10);
	Games_interface game_p = new Games("PUBG","Survive", true, 5);
	Games_interface game_a = new Games("APEX","Shooting", true, 2);
	Holo_interface pekoraHolo = new Holo("Usada pekora",18,160.0,48.0,"pekopeko!","HAHAHA!~",game_m);
	Holo_interface marineHolo = new Holo("Marine",20,162.0,50.0,"eroeor!","gagigagi!~",game_p);
	Holo_interface neolHolo = new Holo("Neol",22,165.0,53.0,"....!","www",game_a);

//	@Bean("feedback1")
//	public Feedback f1() {
//		return new Feedback();
//	}
	
	@Bean("Mixer")
	public Mixer_interface mix1() {
		return new Mixer(pekoraHolo,marineHolo);
	}
//	@Bean("Trans")
//	public DataSource dataSource() {
//		DataSource ds =new datasource
//		return ds;
//	}
//	@Bean("Pekora")//bean.name()
//	@Value("${Holo.age}+${Holo.height}+${Holo.weight}")//bean.value()
//	public Holo_interface member01() {
//		Holo_interface pekoraHolo = new Holo("Usada pekora",18,160.0,48.0,"pekopeko!","HAHAHA!~");
//		return pekoraHolo;
//	}
//	
//	@Bean("Marine")
//	public Holo_interface member02() {
//		Holo_interface marineHolo = new Holo("Marine",20,162.0,50.0,"eroeor!","gagigagi!~");
//		return marineHolo;
//	}
//	
//	@Bean("Neol")
//	public Holo_interface member03() {
//		Holo_interface neolHolo = new Holo("Neol",22,165.0,53.0,"....!","www");
//		return neolHolo;
//	}
//	
//	@Bean("Mario")
//	public Games_interface nintendo_mario() {
//		return new Games("Nintendo Mario","adventure games",false,30);
//	}
//	
//	@Bean("Uta1")
//	public Music_interface song1(){
//		return new Music("紅蓮華","Jpop","Lisa","Lisa");
//	}
//	上課內容
//	@Bean("SetFile1")
//	public SetHoloFile_interface file1() {
//		SetHoloFile_interface setHoloFile = new SetHoloFile("‪D:\\Download","pekora!");
//		return setHoloFile;
//	}
//	String inFilePath;
//	String outFilePath;
//	@Bean("InFile")
//	public File inFile(){
//		File file =new File(inFilePath);
//		return file;
//	}
//	@Bean("OutFile")
//	public File outFile(){
//		File file =new File(outFilePath);
//		return file;
//	}
//	public InputStream fis() {
//		InputStream is = null;
//		try {
//			is = new FileInputStream(inFile());
//			return is;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}
//	}
//	public OutputStream fos() {
//		try {
//			OutputStream os =null;
//			return os;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
//	}
}
