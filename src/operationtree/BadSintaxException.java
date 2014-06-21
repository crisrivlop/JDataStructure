package operationtree;


public class BadSintaxException extends NumberFormatException{

	private String error;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BadSintaxException(String string) {
		// TODO Auto-generated constructor stub
		error = string;
	}

	
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return error;
	}
	
	
}
