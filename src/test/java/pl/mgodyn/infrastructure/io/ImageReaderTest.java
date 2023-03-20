package pl.mgodyn.infrastructure.io;

import org.junit.jupiter.api.Test;
import pl.mgodyn.domain.model.Image;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ImageReaderTest {

    private final ImageReaderImpl underTest = new ImageReaderImpl();

    @Test
    void givenImagePath_whenImageReaderIsInvoked_thenReturnsImageObject() {
        // given
        final String imagePath = "src/test/resources/ascii-pineapple.jpg";
        final File image = new File(imagePath);

        // when
        final Image actual = underTest.read(image);

        // then
        final Image expected = new Image(700, 467);
        assertAll("Should return image with appropriate width and height",
                () -> assertThat(actual.width()).isEqualTo(expected.width()),
                () -> assertThat(actual.height()).isEqualTo(expected.height())
        );
    }
}