package programmingtest.errorhandling;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;
		
	private Integer status;
	
	public AppException(String message, int status) {
		super(message);
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
}
