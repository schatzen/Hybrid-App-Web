package vo;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVo {

	//parameter name
	String title;         
	MultipartFile photo;
	
	//��������
	String filename;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
}
