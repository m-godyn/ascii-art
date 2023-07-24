package pl.mgodyn.asciiart.application.validator;

import pl.mgodyn.asciiart.application.validator.rules.FileExistenceValidationRule;
import pl.mgodyn.asciiart.application.validator.rules.FileExtensionValidationRule;
import pl.mgodyn.asciiart.application.validator.rules.LengthValidationRule;

import java.util.List;

public final class AsciiArtValidationChain {

    private List<ValidationRule> rules;

    private AsciiArtValidationChain() {
        rules = List.of(
                new LengthValidationRule(),
                new FileExistenceValidationRule(),
                new FileExtensionValidationRule()
        );
    }

    public static boolean validateAndHandleErrors(String[] args) {
        AsciiArtValidationChain validationChain = new AsciiArtValidationChain();
        return validationChain.validate(args);
    }

    private boolean validate(String[] args) {
        for (ValidationRule rule : rules) {
            if (!rule.isValid(args)) {
                System.err.println(rule.getErrorMessage());
                return false;
            }
        }
        return true;
    }
}
