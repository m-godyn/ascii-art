package pl.mgodyn.application;

import org.junit.jupiter.api.Test;
import pl.mgodyn.asciiart.application.validator.rules.FileExistenceValidationRule;
import pl.mgodyn.asciiart.application.validator.rules.FileExtensionValidationRule;
import pl.mgodyn.asciiart.application.validator.rules.LengthValidationRule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationRuleTest {

    @Test
    void givenEmptyArgs_whenValidatingLength_isInvalid() {
        // given
        String[] args = {};
        var lengthValidationRule = new LengthValidationRule();

        // when
        BooleanSupplier validateLength = () -> lengthValidationRule.isValid(args);

        // then
        assertFalse(validateLength);
    }

    @Test
    void givenPathToExistentFile_whenValidatingExistence_isValid() throws IOException {
        // given
        File tempFile = Files.createTempFile("test", ".jpg").toFile();
        assertTrue(tempFile.exists());
        String[] args = {tempFile.getPath()};
        var fileExistenceValidationRule = new FileExistenceValidationRule();

        // when
        BooleanSupplier validateFileExistence = () -> fileExistenceValidationRule.isValid(args);

        // then
        assertTrue(validateFileExistence);
    }

    @Test
    void givenPathToNonExistentFile_whenValidatingExistence_isInvalid() {
        // given
        String[] args = {"non_existing_file.jpg"};
        var fileExistenceValidationRule = new FileExistenceValidationRule();

        // when
        BooleanSupplier validateFileExistence = () -> fileExistenceValidationRule.isValid(args);

        // then
        assertFalse(validateFileExistence);
    }

    @Test
    void givenProperFileExtension_whenValidatingFileExtension_isValid() {
        // given
        String[] args = {"image.png"};
        var fileExtensionValidationRule = new FileExtensionValidationRule();

        // when
        BooleanSupplier validateFileExtension = () -> fileExtensionValidationRule.isValid(args);

        // then
        assertTrue(validateFileExtension);
    }

    @Test
    void givenWrongFileExtension_whenValidatingFileExtension_isInvalid() {
        // given
        String[] args = {"document.docx"};
        var fileExtensionValidationRule = new FileExtensionValidationRule();

        //when
        BooleanSupplier validateFileExtension = () -> fileExtensionValidationRule.isValid(args);

        // then
        assertFalse(validateFileExtension);
    }
}
