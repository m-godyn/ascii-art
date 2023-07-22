package pl.mgodyn.asciiart.utils;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ImageUtils {

    private static final double PROPORTION = 3.175;

    private ImageUtils() {
    }

    public static BufferedImage readImage(final String imagePath, ScreenSizeProvider screenSizeProvider) {
        Objects.requireNonNull(imagePath);
        Objects.requireNonNull(screenSizeProvider);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return resize(image, screenSizeProvider);
    }

    public static BufferedImage resize(BufferedImage image, ScreenSizeProvider screenSizeProvider) {
        var targetWidth = calculateTargetImageWidth(screenSizeProvider);
        return image.getWidth() > targetWidth ? Scalr.resize(image, targetWidth) : image;
    }

    private static int calculateTargetImageWidth(ScreenSizeProvider screenSizeProvider) {
        return (int) (screenSizeProvider.getScreenSize().getWidth() / PROPORTION);
    }
}
