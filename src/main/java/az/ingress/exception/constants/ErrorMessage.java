package az.ingress.exception.constants;

public enum ErrorMessage {
    COURSE_NOT_FOUND,
    TRAINING_NOT_FOUND;

    public static String toString(ErrorMessage errorMessage) {
        return errorMessage.toString();
    }
}
