package pl.mgodyn.asciiart.application;

import pl.mgodyn.asciiart.converter.Converter;
import pl.mgodyn.asciiart.io.AsciiArtPrinter;
import pl.mgodyn.asciiart.io.ImageHelper;
import pl.mgodyn.asciiart.io.ImageHelperImpl;

class AsciiArtController {

    private final ImageHelper imageHelper = new ImageHelperImpl();
    private final Converter converter = new Converter();
    private final AsciiArtPrinter printer = new AsciiArtPrinter();

    void run(final String imagePath) {
        imageHelper.readImage(imagePath);
        for (int y = 0; y < imageHelper.getHeight(); y++) {
            for (int x = 0; x < imageHelper.getWidth(); x++) {
                var pixel = imageHelper.getRGB(x, y);
                var ascii = converter.convertPixel2Ascii(pixel);
                printer.add2Row(ascii);
            }
            printer.createNewRow();
        }
        printer.print();
    }
}
