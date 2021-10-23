package test_springboot;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//javaBean格式 (初始化?

//@Component
//@ConfigurationProperties(prefix = "holo")
public class Holo implements Serializable, Holo_interface{
	private String name;
	private int age;
	private double height;
	private double weight;
	private String says1 ;
	private String says2 ;
	private String feedback;
	//dependency
	private Games_interface games;
	//~dependency

	public Holo(String name, int age, double height, double weight, String says1, String says2,
			Games_interface games) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.says1 = says1;
		this.says2 = says2;
		this.games = games;
		this.feedback = (
				says1+"我是\t"+name+"\n"+
				"今年"+age+"歲\n"+
				"身高"+height+"體重"+weight+"公斤\n"+
				says2+"\n喜歡的遊戲是"+ games.getName()
				);
	}
	public Holo() {
		super();
	}

	
	@Override
	public Games_interface getGames() {
		return games;
	}
	@Override
	public void setGames(Games_interface games) {
		this.games = games;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String getSays1() {
		return says1;
	}

	@Override
	public void setSays1(String says1) {
		this.says1 = says1;
	}

	@Override
	public String getSays2() {
		return says2;
	}

	@Override
	public void setSays2(String says2) {
		this.says2 = says2;
	}

	@Override
	public String getFeedback() {
		return feedback;
	}

	@Override
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
