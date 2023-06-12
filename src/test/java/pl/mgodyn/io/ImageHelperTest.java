package pl.mgodyn.io;

import org.junit.jupiter.api.Test;
import pl.mgodyn.asciiart.converter.ImageResizer;
import pl.mgodyn.asciiart.converter.ImageResizerImpl;
import pl.mgodyn.asciiart.io.ImageHelper;
import pl.mgodyn.asciiart.io.ImageHelperImpl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class ImageHelperTest {

    private ImageResizer<BufferedImage> imageResizer = spy(new ImageResizerImpl());
    private final ImageHelper underTest = new ImageHelperImpl(new ImageResizerImpl());

    @Test
    void givenImagePath_whenImageReaderIsInvoked_thenReturnsBufferedImageObject() {
        // given
        final String imagePath = "src/test/resources/ascii-pineapple.jpg";
        BufferedImage givenImage = getBufferedImage(imagePath);
        when(imageResizer.resize(givenImage)).thenReturn(givenImage);

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

    private BufferedImage getBufferedImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}