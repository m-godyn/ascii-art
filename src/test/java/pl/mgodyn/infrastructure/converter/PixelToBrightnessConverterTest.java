package pl.mgodyn.infrastructure.converter;

import org.junit.jupiter.api.Test;
import pl.mgodyn.domain.converter.PixelToBrightnessConverter;
import pl.mgodyn.domain.model.Pixel;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PixelToBrightnessConverterTest {

    private final PixelToBrightnessConverter underTest = new PixelToBrightnessConverterImpl();

    @Test
    void givenPixel_whenConvertToBrightness_thenReturnsInt() {
        // given
        Pixel pixel = new Pixel(0, 60, 240);

        // when
        int actual = underTest.convertToBrightness(pixel);

        // then
        int expected = 100;
        assertEquals(expected, actual);
    }
}
