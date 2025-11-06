package co.edu.co.extraclase.crosscuting.exception;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;

public final class ExtraClaseException extends RuntimeException{

	private static final long serialVersionUID = -433023700129543247L;
	private Throwable rootException;
	private String userMessage;
	private String technicalMessage;

	private ExtraClaseException(final Throwable rootException,final String userMessage,final String technicalMessage) {
	 setRootException(rootException);
	 setUserMessage(userMessage);
     setTechnicalMessage(technicalMessage);
	}

	public static ExtraClaseException create(final String userMessage) {
		return new ExtraClaseException(new Exception(),userMessage,userMessage);
	}
	
	public static ExtraClaseException create(final String userMessage,final String technicalMessage) {
		return new ExtraClaseException(new Exception(),userMessage,technicalMessage);
	}
	
	public static ExtraClaseException create(final Throwable rootException,final String userMessage,final String technicalMessage) {
		return new ExtraClaseException(rootException,userMessage,technicalMessage);
	}
	
	public Throwable getRootException() {
		return rootException;
	}
	
	private void setRootException(final Throwable rootException) {
		this.rootException = ObjectHelper.getDefault(rootException, new Exception());
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
	private void setUserMessage(final String userMessage) {
		this.userMessage =TextHelper.getDefaultWithTrim(userMessage);
	}
	
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	
	private void setTechnicalMessage(final String technicalMessage) {
		this.technicalMessage = TextHelper.getDefaultWithTrim(technicalMessage);
	}
}
