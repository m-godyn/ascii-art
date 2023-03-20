package pl.mgodyn.application;

import pl.mgodyn.infrastructure.io.ImageReaderImpl;
import pl.mgodyn.domain.model.Image;

import java.io.File;

class AsciiArtController {

    private final ImageReadingService imageReadingService = new ImageReadingService();

    void run(final String imagePath) {
        Image image = imageReadingService.readImage(imagePath);
        System.out.println("Successfully loaded image!");
        image.printSize();
        image.printPixels();
    }
}
