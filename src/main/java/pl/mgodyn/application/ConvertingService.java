package pl.mgodyn.application;

import pl.mgodyn.domain.converter.BrightnessToAsciiConverter;
import pl.mgodyn.domain.converter.PixelToBrightnessConverter;
import pl.mgodyn.domain.model.AsciiArt;
import pl.mgodyn.domain.model.Image;
import pl.mgodyn.domain.model.Pixel;
import pl.mgodyn.infrastructure.converter.BrightnessToAsciiConverterImpl;
import pl.mgodyn.infrastructure.converter.PixelToBrightnessConverterImpl;

class ConvertingService {

    private final PixelToBrightnessConverter pixelToBrightnessConverter = new PixelToBrightnessConverterImpl();
    private final BrightnessToAsciiConverter brightnessToAsciiConverter = new BrightnessToAsciiConverterImpl();

    AsciiArt convertToAsciiArt(Image image) {
        char[][] asciiMatrix = new char[image.height()][image.width()];
        Pixel[][] pixels = image.pixels();
        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                var brightness = pixelToBrightnessConverter.convertToBrightness(pixels[y][x]);
                asciiMatrix[y][x] = brightnessToAsciiConverter.convertToAscii(brightness);
            }
        }
        return new AsciiArt(asciiMatrix);
    }

}
