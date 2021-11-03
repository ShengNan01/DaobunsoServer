package springboot;

import java.io.File;

public interface SetHoloFile_interface {

	void setFolder(File folder);

	void setFile();

	String getFilename();

	void setFilename(String filename);

	String getHint();

	void setHint(String hint);

	File getFolder();

}