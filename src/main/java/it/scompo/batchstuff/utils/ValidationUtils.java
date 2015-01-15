package it.scompo.batchstuff.utils;

public abstract class ValidationUtils {

	private ValidationUtils() {

	}

	public static <T> void validateNotNull(T objectToCheck, String message) {

		if (objectToCheck == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static <T> void validateNotNull(T objectToCheck) {

		validateNotNull(objectToCheck, "null element");
	}

}
