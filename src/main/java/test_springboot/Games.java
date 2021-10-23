package test_springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "games")
public class Games implements Games_interface{
	String name;
	String type;
	boolean multiplay;
	int years;
	
	//dependency
	
	//~dependency
	public Games(String name, String type, boolean multiplay, int years) {
		super();
		this.name = name;
		this.type = type;
		this.multiplay = multiplay;
		this.years = years;
	}
	public Games() {
		super();
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
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean isMultiplay() {
		return multiplay;
	}

	@Override
	public void setMultiplay(boolean multiplay) {
		this.multiplay = multiplay;
	}

	@Override
	public int getYears() {
		return years;
	}

	@Override
	public void setYears(int years) {
		this.years = years;
	}
	
}
