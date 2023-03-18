package pl.mgodyn.application;

import pl.mgodyn.io.ImageReader;
import pl.mgodyn.model.Image;

public class AsciiArtController {

    private final ImageReader imageReader = new ImageReader();

    void run(final String imagePath) {
        Image image = imageReader.readImage(imagePath);
        System.out.println("Successfully loaded image!");
        image.printSize();
    }
}
