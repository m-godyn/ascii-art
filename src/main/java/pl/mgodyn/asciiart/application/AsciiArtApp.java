package pl.mgodyn.asciiart.application;

public class AsciiArtApp {

    private static final String APP_NAME = "ASCII Art v0.0.6";

    public static void main(String[] args) {
        System.out.println(APP_NAME);

        final String imagePath = "src/main/resources/leviosa.jpg";

        AsciiArtController asciiArtController = new AsciiArtController();
        asciiArtController.run(imagePath);
    }
}