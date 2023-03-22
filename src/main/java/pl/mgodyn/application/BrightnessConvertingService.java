package pl.mgodyn.application;

import pl.mgodyn.domain.converter.PixelToBrightnessConverter;
import pl.mgodyn.domain.model.Image;
import pl.mgodyn.domain.model.Pixel;
import pl.mgodyn.infrastructure.converter.PixelToBrightnessConverterImpl;

class BrightnessConvertingService {

    private final PixelToBrightnessConverter pixelToBrightnessConverter = new PixelToBrightnessConverterImpl();

    int[][] convertImageToBrightnessMatrix(Image image) {
        int [][] brightnessMatrix = new int[image.height()][image.width()];
        Pixel[][] pixels = image.pixels();
        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                brightnessMatrix[y][x] = pixelToBrightnessConverter.convertToBrightness(pixels[y][x]);
            }
        }
        return brightnessMatrix;
    }

}
