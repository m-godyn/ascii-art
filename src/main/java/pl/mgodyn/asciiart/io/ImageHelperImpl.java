package pl.mgodyn.asciiart.io;

import pl.mgodyn.asciiart.converter.ImageResizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ImageHelperImpl implements ImageHelper {

    private BufferedImage image;
    private final ImageResizer<BufferedImage> imageResizer;

    public ImageHelperImpl(ImageResizer<BufferedImage> imageResizer) {
        this.imageResizer = imageResizer;
    }

    @Override
    public void readImage(final String imagePath) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(imagePath));
            this.image = imageResizer.resize(image);
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
