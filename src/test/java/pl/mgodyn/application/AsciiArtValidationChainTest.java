package pl.mgodyn.application;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.mgodyn.asciiart.application.validator.AsciiArtValidationChain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AsciiArtValidationChainTest {

    @ParameterizedTest
    @MethodSource("validArgs")
    void givenValidArguments_whenValidating_thenIsValid(String[] args) {
        assertTrue(AsciiArtValidationChain.validateAndHandleErrors(args));
    }

    @ParameterizedTest
    @MethodSource("invalidArgs")
    void givenInvalidArguments_whenValidating_thenIsInvalid(String[] args) {
        assertFalse(AsciiArtValidationChain.validateAndHandleErrors(args));
    }

    private static Stream<Arguments> validArgs() throws IOException {
        File tempJpgFile = Files.createTempFile("test", ".jpg").toFile();
        File tempJpegFile = Files.createTempFile("test", ".jpeg").toFile();
        File tempPngFile = Files.createTempFile("test", ".png").toFile();

        String[] argsWithJpg = {tempJpgFile.getPath()};
        String[] argsWithJpeg = {tempJpegFile.getPath()};
        String[] argsWithPng = {tempPngFile.getPath()};

        return Stream.of(
                Arguments.of((Object) argsWithJpg),
                Arguments.of((Object) argsWithJpeg),
                Arguments.of((Object) argsWithPng)
        );
    }

    private static Stream<Arguments> invalidArgs() throws IOException {
        File tempTxtFile = Files.createTempFile("test", ".txt").toFile();
        String tempTxtFilePath = tempTxtFile.getAbsolutePath();

        String[] emptyArgs = {};
        String[] argsWithTxt = {tempTxtFilePath};
        String[] argsWith2Txt = {tempTxtFilePath, tempTxtFilePath};

        return Stream.of(
                Arguments.of((Object) emptyArgs),
                Arguments.of((Object) argsWithTxt),
                Arguments.of((Object) argsWith2Txt)
        );
    }
}
