package pl.mgodyn.infrastructure.converter;

import org.junit.jupiter.api.Test;
import pl.mgodyn.domain.converter.BrightnessToAsciiConverter;

import static org.junit.jupiter.api.Assertions.*;


class BrightnessToAsciiConverterTest {

    private final BrightnessToAsciiConverter underTest = new BrightnessToAsciiConverterImpl();

    @Test
    void givenBrightnessNumber_whenConvertingToAsciiChar_thenReturnsAsciiChar() {
        // given
        final int brightness1 = 0;
        final int brightness2 = 128;
        final int brightness3 = 255;

        // when
        final char actual1 = underTest.convertToAscii(brightness1);
        final char actual2 = underTest.convertToAscii(brightness2);
        final char actual3 = underTest.convertToAscii(brightness3);

        // then
        final char expected1 = '`';
        final char expected2 = 'v';
        final char expected3 = '$';
        assertAll(
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2),
                () -> assertEquals(expected3, actual3)
        );
    }
}
