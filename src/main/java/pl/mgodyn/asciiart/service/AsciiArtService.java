package pl.mgodyn.asciiart.service;

import pl.mgodyn.asciiart.converter.Converter;
import pl.mgodyn.asciiart.io.AsciiArtPrinter;

import java.awt.image.BufferedImage;

public class AsciiArtService {

    private final Converter converter;
    private final AsciiArtPrinter printer;

    public AsciiArtService() {
        this.converter = new Converter();
        this.printer = new AsciiArtPrinter();
    }

    public void convert(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                var pixel = image.getRGB(x, y);
                var ascii = converter.convertPixel2Ascii(pixel);
                printer.add2Row(ascii);
            }
            printer.createNewRow();
        }
    }

    public void print() {
        printer.print();
    }
}
