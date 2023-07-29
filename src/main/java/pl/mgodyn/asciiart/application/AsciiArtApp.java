package pl.mgodyn.asciiart.application;

import pl.mgodyn.asciiart.application.validator.AsciiArtValidationChain;

public class AsciiArtApp {

    public static void main(String[] args) {
        if (!AsciiArtValidationChain.validateAndHandleErrors(args)) {
            return;
        }

        final String imagePath = args[0];

        AsciiArtController asciiArtController = new AsciiArtController();
        asciiArtController.run(imagePath);
    }
}