package test_springboot;

public class Hina {
	public String name;
	public int age;
	public double height;
	public double weight;
	public String says1 ;
	public String says2 ;
	public String feedback;
	
	public Hina(String name, int age, double height, double weight, String says1, String says2) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.says1 = says1;
		this.says2 = says2;
		this.feedback = (
				says1+"我是\t"+name+"\n"+
				"今年"+age+"歲\n"+
				"身高"+height+"體重"+weight+"公斤\n"+
				says2
				);
	}
	
	public String getFeedback() {
		return feedback;
	}
}
