package exceptions;

public class SLogoParsingException extends Exception {

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	public SLogoParsingException() {
	}

	public SLogoParsingException(String arg0) {
		super(arg0);
	}

	public SLogoParsingException(Throwable cause) {
		super(cause);
	}

	public SLogoParsingException(String message, Throwable cause) {
		super(message, cause);
	}

	public SLogoParsingException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
