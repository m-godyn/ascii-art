package pl.mgodyn.domain.converter;

import pl.mgodyn.domain.model.Pixel;

public interface PixelToBrightnessConverter {

    int convertToBrightness(Pixel pixel);
}
