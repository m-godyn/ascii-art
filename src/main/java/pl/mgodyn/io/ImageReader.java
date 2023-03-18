package pl.mgodyn.io;

import pl.mgodyn.model.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {

    public Image readImage(final String fileName) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return new Image(bufferedImage.getWidth(), bufferedImage.getHeight());
    }
}
