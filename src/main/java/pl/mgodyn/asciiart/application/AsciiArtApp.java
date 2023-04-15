package pl.mgodyn.asciiart.application;

public class AsciiArtApp {

    public static void main(String[] args) {
        final String imagePath = "src/main/resources/ascii-pineapple.jpg";

        AsciiArtController asciiArtController = new AsciiArtController();
        asciiArtController.run(imagePath);
    }
}