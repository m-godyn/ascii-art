package pl.mgodyn.infrastructure.io;

import org.junit.jupiter.api.Test;
import pl.mgodyn.domain.io.ImageReader;
import pl.mgodyn.domain.model.Image;
import pl.mgodyn.domain.model.Pixel;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ImageReaderTest {

    private final ImageReader underTest = new ImageReaderImpl();

    @Test
    void givenImagePath_whenImageReaderIsInvoked_thenReturnsImageObject() {
        // given
        final String imagePath = "src/test/resources/ascii-pineapple.jpg";
        final File image = new File(imagePath);

        // when
        final Image actual = underTest.read(image);

        // then
        final Image expected = new Image(700, 467, new Pixel[467][700]);
        assertAll("Should return image with appropriate width and height",
                () -> assertThat(actual.width()).isEqualTo(expected.width()),
                () -> assertThat(actual.height()).isEqualTo(expected.height()),
                () -> assertThat(actual.pixels().length).isEqualTo(expected.pixels().length),
                () -> assertThat(actual.pixels()[0].length).isEqualTo(expected.pixels()[0].length)
        );
    }
}