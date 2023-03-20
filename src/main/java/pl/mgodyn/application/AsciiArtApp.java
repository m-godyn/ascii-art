package pl.mgodyn.application;

public class AsciiArtApp {

    private static final String APP_NAME = "ASCII Art v0.0.2";

    public static void main(String[] args) {
        System.out.println(APP_NAME);

        final String imagePath = "src/main/resources/ascii-pineapple.jpg";

        AsciiArtController asciiArtController = new AsciiArtController();
        asciiArtController.run(imagePath);
    }
}