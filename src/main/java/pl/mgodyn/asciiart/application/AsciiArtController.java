package pl.mgodyn.asciiart.application;

import pl.mgodyn.asciiart.converter.Converter;
import pl.mgodyn.asciiart.io.AsciiArtPrinter;
import pl.mgodyn.asciiart.io.ImageReader;

class AsciiArtController {

    private final ImageReader reader = new ImageReader();
    private final Converter converter = new Converter();
    private final AsciiArtPrinter printer = new AsciiArtPrinter();

    void run(final String imagePath) {
        var image = reader.readAsBufferedImage(imagePath);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                var pixel = image.getRGB(x, y);
                var ascii = converter.convertPixel2Ascii(pixel);
                printer.add2Row(ascii);
            }
            printer.printRow();
        }
    }
}
