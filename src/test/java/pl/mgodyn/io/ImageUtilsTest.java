package pl.mgodyn.io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.mgodyn.asciiart.utils.DefaultScreenSizeProvider;
import pl.mgodyn.asciiart.utils.ImageUtils;
import pl.mgodyn.asciiart.utils.ScreenSizeProvider;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ImageUtilsTest {

    private static BufferedImage testImage;

    @BeforeAll
    static void beforeAll() {
        try {
            testImage = ImageIO.read(new File("src/test/resources/ascii-pineapple-700x467.jpg"));
        } catch (IOException e) {
            System.err.println("Could not read test file!");
            throw new RuntimeException(e);
        }
    }

    @Test
    void givenImagePath_whenImageReaderIsInvoked_thenReturnsBufferedImageObject() {
        // given
        final String imagePath = "src/test/resources/ascii-pineapple-322x215.jpg";

        // when
        var actual = ImageUtils.readImage(imagePath, new DefaultScreenSizeProvider());

        // then
        final var expectedHeight = 215;
        final var expectedWidth = 322;
        final var expectedRGB = -16747309;
        assertAll("Should return proper values with appropriate width and height and RGB",
                () -> assertEquals(expectedWidth, actual.getWidth()),
                () -> assertEquals(expectedHeight, actual.getHeight()),
                () -> assertEquals(expectedRGB, actual.getRGB(0, 0))
        );
    }

    @Test
    void shouldThrowException_whenImageIsNull() {
        // given
        final String imagePath = null;
        // expect
        assertThrows(NullPointerException.class, () -> ImageUtils.readImage(imagePath, new DefaultScreenSizeProvider()));
    }

    @Test
    void given3840x2160Resolution_whenResizing_thenShouldResizeImage() {
        // given
        ScreenSizeProvider screenSizeProviderMock = mock(ScreenSizeProvider.class);
        Dimension screenSize = new Dimension(3840, 2160);
        when(screenSizeProviderMock.getScreenSize())
                .thenReturn(screenSize);

        // when
        var actual = ImageUtils.resize(testImage, screenSizeProviderMock);

        // then
        var expectedWidth = testImage.getWidth();
        assertEquals(expectedWidth, actual.getWidth());
    }

    @Test
    void given2560x1440Resolution_whenResizing_thenShouldResizeImage() {
        // given
        ScreenSizeProvider screenSizeProviderMock = mock(ScreenSizeProvider.class);
        Dimension screenSize = new Dimension(2560, 1440);
        when(screenSizeProviderMock.getScreenSize())
                .thenReturn(screenSize);

        // when
        var actual = ImageUtils.resize(testImage, screenSizeProviderMock);

        // then
        var expectedWidth = testImage.getWidth();
        assertEquals(expectedWidth, actual.getWidth());
    }

    @Test
    void given1366x768Resolution_whenResizing_thenShouldResizeImage() {
        // given
        ScreenSizeProvider screenSizeProviderMock = mock(ScreenSizeProvider.class);
        Dimension screenSize = new Dimension(1366, 768);
        when(screenSizeProviderMock.getScreenSize())
                .thenReturn(screenSize);

        // when
        var actual = ImageUtils.resize(testImage, screenSizeProviderMock);

        // then
        var expectedWidth = 430;
        assertEquals(expectedWidth, actual.getWidth());
    }
}
