package pl.mgodyn.asciiart.converter;

import org.imgscalr.Scalr;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ImageResizerImpl implements ImageResizer<BufferedImage> {

    private static final double PROPORTION = 3.175;

    @Override
    public BufferedImage resize(BufferedImage image) {
        var targetWidth = calculateTargetImageWidth();
        return image.getWidth() > targetWidth ? Scalr.resize(image, targetWidth) : image;
    }

    @Override
    public int getScreenSizeWidth() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) size.getWidth();
    }

    private int calculateTargetImageWidth() {
        return (int) (getScreenSizeWidth() / PROPORTION);
    }
}
