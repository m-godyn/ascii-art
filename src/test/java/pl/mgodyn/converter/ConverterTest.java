package pl.mgodyn.converter;

import org.junit.jupiter.api.Test;
import pl.mgodyn.asciiart.converter.Converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {

    private final Converter underTest = new Converter();

    @Test
    void givenLightestRGB_whenConvertToAscii_thenReturnsChar() {
        // given
        final int pixel = 16777215; // red = 255, green = 255, blue = 255

        // when
        final var actual = underTest.convertPixel2Ascii(pixel);

        // then
        final char expected = '$';
        assertEquals(expected, actual);
    }

    @Test
    void givenDarkestRGB_whenConvertToAscii_thenReturnsChar() {
        // given
        final int pixel = 0; // red = 0, green = 0, blue = 0

        // when
        final var actual = underTest.convertPixel2Ascii(pixel);

        // then
        final char expected = '`';
        assertEquals(expected, actual);
    }

    @Test
    void givenAverageRGB_whenConvertToAscii_thenReturnsChar() {
        // given
        final int pixel = 8421504; // red = 128, green = 128, blue = 128

        // when
        final var actual = underTest.convertPixel2Ascii(pixel);

        // then
        final char expected = 'v';
        assertEquals(expected, actual);
    }

    @Test
    void givenCustomRGB_whenConvertToAscii_thenReturnsChar() {
        // given
        final int pixel = 33008; // red = 0, green = 128, blue = 240

        // when
        final var actual = underTest.convertPixel2Ascii(pixel);

        // then
        final char expected = 'u';
        assertEquals(expected, actual);
    }
}
