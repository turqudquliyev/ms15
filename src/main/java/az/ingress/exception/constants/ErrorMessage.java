package az.ingress.exception.constants;

public enum ErrorMessage {
    STUDENT_NOT_FOUND;

    public static String toString(ErrorMessage errorMessage) {
        return errorMessage.toString();
    }
}
