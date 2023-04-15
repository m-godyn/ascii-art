package pl.mgodyn.asciiart.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ImageHelperImpl implements ImageHelper {

    private BufferedImage image;

    public void readImage(final String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public int getWidth() {
        Objects.requireNonNull(image);
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        Objects.requireNonNull(image);
        return image.getHeight();
    }

    @Override
    public int getRGB(int x, int y) {
        Objects.requireNonNull(image);
        return image.getRGB(x, y);
    }


}
