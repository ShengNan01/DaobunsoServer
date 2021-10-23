package test_springboot;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Mixer implements Mixer_interface{
	private Holo_interface holo1;
	private Holo_interface holo2;
	public Mixer(Holo_interface pekoraHolo, Holo_interface marineHolo) {
		super();
		this.holo1 = pekoraHolo;
		this.holo2 = marineHolo;
	}
	public Mixer() {
		super();
	}
	
	
	@Override
	public String mix1(){
		return holo1.getName()+"以及\t"+holo2.getName()+"進行連動囉!!";
	}
	@Override
	public String mix2(){
		return holo1.getName()+"與"+holo2.getName()+"正在一起玩"
	+holo1.getGames().getName()+"和"+holo2.getGames().getName();
	}
	@Override
	public String mix3(){
		return holo1.getName()+"以及\t"+holo2.getName()+"一起唱歌囉!!";
	}
	
}
