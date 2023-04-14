package pl.mgodyn.asciiart.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {

    public BufferedImage readAsBufferedImage(final String imagePath) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return bufferedImage;
    }
}
