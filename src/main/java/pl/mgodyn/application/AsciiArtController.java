package pl.mgodyn.application;

import pl.mgodyn.domain.model.Image;

class AsciiArtController {

    private final ImageReadingService imageReadingService = new ImageReadingService();
    private final ConvertingService convertingService = new ConvertingService();

    void run(final String imagePath) {
        var image = getImage(imagePath);
        var asciiArt = convertingService.convertToAsciiArt(image);
        asciiArt.print();
    }

    private Image getImage(String imagePath) {
        var image = imageReadingService.readImage(imagePath);
        System.out.println("Successfully loaded image!");
        image.printSize();
        return image;
    }
}
