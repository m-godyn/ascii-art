package pl.mgodyn.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.mgodyn.asciiart.converter.ImageResizer;
import pl.mgodyn.asciiart.converter.ImageResizerImpl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ImageResizerTest {

    ImageResizer<BufferedImage> underTest = spy(new ImageResizerImpl());
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
    void given3840x2160Resolution_whenResizing_thenShouldResizeImage() {
        // given
        when(underTest.getScreenSizeWidth())
                .thenReturn(3840);

        // when
        var actual = underTest.resize(testImage);

        // then
        var expectedWidth = testImage.getWidth();
        assertEquals(expectedWidth, actual.getWidth());
    }

    @Test
    void given2560x1440Resolution_whenResizing_thenShouldResizeImage() {
        // given
        when(underTest.getScreenSizeWidth())
                .thenReturn(2560);

        // when
        var actual = underTest.resize(testImage);

        // then
        var expectedWidth = testImage.getWidth();
        assertEquals(expectedWidth, actual.getWidth());
    }

    @Test
    void given1366x768Resolution_whenResizing_thenShouldResizeImage() {
        // given
        when(underTest.getScreenSizeWidth())
                .thenReturn(1366);

        // when
        var actual = underTest.resize(testImage);

        // then
        var expectedWidth = 430;
        assertEquals(expectedWidth, actual.getWidth());
    }
}
