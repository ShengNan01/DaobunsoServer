package springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "music")
//@EnableAspectJAutoProxy
public class Music implements Music_interface{
	
	private String name ;
	private String type ;
	private String singer;
	private String producers;
	
	//dependency
	
	//~dependency
	public Music(String name, String type, String singer, String producers) {
		super();
		this.name = name;
		this.type = type;
		this.singer = singer;
		this.producers = producers;
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
	public String getSinger() {
		return singer;
	}
	@Override
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String getProducers() {
		return producers;
	}
	@Override
	public void setProducers(String producers) {
		this.producers = producers;
	}
	
}
