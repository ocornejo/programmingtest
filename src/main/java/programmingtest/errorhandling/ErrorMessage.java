package programmingtest.errorhandling;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	@XmlElement(name = "status")
	int status;
	
	@XmlElement(name = "message")
	String message;
	
	public ErrorMessage(AppException ex){
		this.status = ex.getStatus();
		this.message = ex.getMessage();
	}
}
