package test_springboot;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.w3c.dom.events.Event;

@Component("toFile")
public abstract class SetHoloFile implements Event, SetHoloFile_interface{
	private File folder;
	@Resource
	private String filename;
	@Resource
	private String hint;

	
	
	public SetHoloFile() {
		super();
	}
	public SetHoloFile(File folder, String filename) {
		super();
		this.folder = folder;
		this.filename = filename;
		this.hint = "建構檔案:\t" + filename+"";
	}
	
	@Override
	public void setFolder(File folder) {
		if(folder.exists()) {
			System.out.println("已有重複資料夾!");
		}else {
			folder.mkdirs();
			System.out.println("新建資料夾!");
		}	
	}

	@Override
	public void setFile() {
		File file = new File(folder,filename);
		try (PrintWriter pw = new PrintWriter(new FileWriter(file,true));){
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public String getFilename() {
		return filename;
	}
	@Override
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String getHint() {
		return hint;
	}
	@Override
	public void setHint(String hint) {
		this.hint = hint;
	}
	@Override
	public File getFolder() {
		return folder;
	}
	
}
