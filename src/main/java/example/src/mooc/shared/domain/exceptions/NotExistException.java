package example.src.mooc.shared.domain.exceptions;

public final class NotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotExistException(final String message) {
		super(message);
	}

}
