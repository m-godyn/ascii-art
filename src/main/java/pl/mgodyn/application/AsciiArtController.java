package pl.mgodyn.application;

import pl.mgodyn.domain.model.Image;

class AsciiArtController {

    private final ImageReadingService imageReadingService = new ImageReadingService();
    private final BrightnessConvertingService brightnessConvertingService = new BrightnessConvertingService();

    void run(final String imagePath) {
        Image image = imageReadingService.readImage(imagePath);
        System.out.println("Successfully loaded image!");
        image.printSize();
        int[][] brightnessMatrix = brightnessConvertingService.convertImageToBrightnessMatrix(image);
        System.out.println("Successfully constructed brightness matrix!");
        System.out.printf("Brightness matrix size: %s x %s%n", brightnessMatrix[0].length, brightnessMatrix.length);
        System.out.println("Iterating through brightness matrix...");
        for (int[] row : brightnessMatrix) {
            for (int brightness : row) {
                System.out.printf("%s ", brightness);
            }
            System.out.println();
        }
    }
}
