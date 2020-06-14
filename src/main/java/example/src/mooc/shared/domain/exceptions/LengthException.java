package example.src.mooc.shared.domain.exceptions;

public final class LengthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LengthException(final String message) {
		super(message);
	}

}
