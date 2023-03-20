package pl.mgodyn.infrastructure.io;

import pl.mgodyn.domain.io.ImageReader;
import pl.mgodyn.domain.model.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReaderImpl implements ImageReader {

    public Image read(final File image) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(image);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return new Image(bufferedImage.getWidth(), bufferedImage.getHeight());
    }
}
