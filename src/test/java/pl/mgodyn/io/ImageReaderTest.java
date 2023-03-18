package pl.mgodyn.io;

import org.junit.jupiter.api.Test;
import pl.mgodyn.model.Image;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ImageReaderTest {

    private final ImageReader underTest = new ImageReader();

    @Test
    void givenImagePath_whenImageReaderIsInvoked_thenReturnsImageObject() {
        // given
        final String imagePath = "src/test/resources/ascii-pineapple.jpg";

        // when
        final Image actual = underTest.readImage(imagePath);

        // then
        final Image expected = new Image(700, 467);
        assertAll("Should return image with appropriate width and height",
                () -> assertThat(actual.width()).isEqualTo(expected.width()),
                () -> assertThat(actual.height()).isEqualTo(expected.height())
        );
    }
}