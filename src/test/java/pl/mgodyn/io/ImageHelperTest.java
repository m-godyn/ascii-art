package pl.mgodyn.io;

import org.junit.jupiter.api.Test;
import pl.mgodyn.asciiart.io.ImageHelper;
import pl.mgodyn.asciiart.io.ImageHelperImpl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImageHelperTest {

    private final ImageHelper underTest = new ImageHelperImpl();

    @Test
    void givenImagePath_whenImageReaderIsInvoked_thenReturnsBufferedImageObject() {
        // given
        final String imagePath = "src/test/resources/ascii-pineapple.jpg";

        // when
        underTest.readImage(imagePath);

        // then
        final var expectedHeight = 467;
        final var expectedWidth = 700;
        final var expectedRGB = -16681775;
        assertAll("Should return proper values with appropriate width and height and RGB",
                () -> assertEquals(expectedWidth, underTest.getWidth()),
                () -> assertEquals(expectedHeight, underTest.getHeight()),
                () -> assertEquals(expectedRGB, underTest.getRGB(0,0))
        );
    }

    @Test
    void shouldThrowException_whenImageNotRead_andTriesToUseOtherMethods() {
        // given
        // expect
        assertAll(
                () -> assertThrows(NullPointerException.class, underTest::getHeight),
                () -> assertThrows(NullPointerException.class, underTest::getWidth),
                () -> assertThrows(NullPointerException.class, () -> underTest.getRGB(0, 0))
        );
    }
}