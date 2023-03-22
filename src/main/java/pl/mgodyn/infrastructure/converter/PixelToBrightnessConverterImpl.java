package pl.mgodyn.infrastructure.converter;

import pl.mgodyn.domain.converter.PixelToBrightnessConverter;
import pl.mgodyn.domain.model.Pixel;

public class PixelToBrightnessConverterImpl implements PixelToBrightnessConverter {

    @Override
    public int convertToBrightness(Pixel pixel) {
        return (pixel.red() + pixel.green() + pixel.blue()) / 3;
    }
}
