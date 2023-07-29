package pl.mgodyn.asciiart.application.validator.rules;

import pl.mgodyn.asciiart.application.validator.ValidationRule;

public class FileExtensionValidationRule implements ValidationRule {

    private final String ERROR_MESSAGE = "File not supported! It must be either .png, .jpg or .jpeg!";

    @Override
    public boolean isValid(String[] args) {
        String fileName = args[0];
        return fileName.matches("(?i).*\\.(png|jpg|jpeg)$");
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
