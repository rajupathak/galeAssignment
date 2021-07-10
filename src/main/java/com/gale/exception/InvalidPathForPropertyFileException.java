package com.gale.exception;

@SuppressWarnings("serial")
public class InvalidPathForPropertyFileException extends FrameworkException {

	public InvalidPathForPropertyFileException(String message) {
		super(message);

	}

	public InvalidPathForPropertyFileException(String message, Throwable cause) {
		super(message, cause);
	}
}
