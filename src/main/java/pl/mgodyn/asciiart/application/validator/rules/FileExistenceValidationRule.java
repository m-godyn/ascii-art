package pl.mgodyn.asciiart.application.validator.rules;

import pl.mgodyn.asciiart.application.validator.ValidationRule;

import java.io.File;

public class FileExistenceValidationRule implements ValidationRule {

    private final String ERROR_MESSAGE = "File does not exist!";

    @Override
    public boolean isValid(String[] args) {
        File file = new File(args[0]);
        return file.exists();
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
