package pl.mgodyn.asciiart.application.validator.rules;

import pl.mgodyn.asciiart.application.validator.ValidationRule;

public class LengthValidationRule implements ValidationRule {

    private final String ERROR_MESSAGE = "Too many or no arguments!";

    @Override
    public boolean isValid(String[] args) {
        return args.length == 1;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
