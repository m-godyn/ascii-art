package pl.mgodyn.io;

import org.junit.jupiter.api.Test;
import pl.mgodyn.asciiart.io.ImageReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ImageReaderTest {

    private final ImageReader underTest = new ImageReader();

    @Test
    void givenImagePath_whenImageReaderIsInvoked_thenReturnsBufferedImageObject() {
        // given
        final String imagePath = "src/test/resources/ascii-pineapple.jpg";

        // when
        final var actual = underTest.readAsBufferedImage(imagePath);

        // then
        final var expectedHeight = 467;
        final var expectedWidth = 700;
        assertAll("Should return image with appropriate width and height",
                () -> assertThat(actual.getHeight()).isEqualTo(expectedHeight),
                () -> assertThat(actual.getWidth()).isEqualTo(expectedWidth)
        );
    }
}