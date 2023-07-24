package pl.mgodyn.asciiart.application;

import pl.mgodyn.asciiart.application.validator.AsciiArtValidationChain;

public class AsciiArtApp {

    public static void main(String[] args) {
        final String imagePath = "src/main/resources/ascii-pineapple.jpg";

        if (!AsciiArtValidationChain.validateAndHandleErrors(args)) {
            return;
        }

        AsciiArtController asciiArtController = new AsciiArtController();
        asciiArtController.run(imagePath);
    }
}