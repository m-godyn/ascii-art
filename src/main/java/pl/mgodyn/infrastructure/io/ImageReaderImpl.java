package pl.mgodyn.infrastructure.io;

import pl.mgodyn.domain.io.ImageReader;
import pl.mgodyn.domain.model.Image;
import pl.mgodyn.domain.model.Pixel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReaderImpl implements ImageReader {

    @Override
    public Image read(final File image) {
        BufferedImage bufferedImage = convertToBufferedImage(image);

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        Pixel[][] pixels = new Pixel[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = bufferedImage.getRGB(x, y);

                int red = (pixel >> 16) & 0xff;
                int blue = (pixel >> 8) & 0xff;
                int green = pixel & 0xff;

                pixels[y][x] = new Pixel(red, blue, green);
            }
        }
        return new Image(width, height, pixels);
    }

    private BufferedImage convertToBufferedImage(File image) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(image);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return bufferedImage;
    }
}
