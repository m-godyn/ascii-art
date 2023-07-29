package pl.mgodyn.asciiart.application.validator;

public interface ValidationRule {

    boolean isValid(String[] args);

    String getErrorMessage();
}
