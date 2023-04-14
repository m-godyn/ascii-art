package pl.mgodyn.asciiart.converter;

public class Converter {

    private static final String ASCII_CHARS = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
    private static final short MAX_POSSIBLE_BRIGHTNESS = 255;
    private static final double PROPORTION = (double) (ASCII_CHARS.length() - 1) / MAX_POSSIBLE_BRIGHTNESS;

    public char convertPixel2Ascii(int pixel) {
        var brightness = convertRGB2Brightness(pixel);
        return convertBrightness2Ascii(brightness);
    }

    private int convertRGB2Brightness(int pixel) {
        var red = getRedFromPixel(pixel);
        var blue = getBlueFromPixel(pixel);
        var green = getGreenFromPixel(pixel);
        return (red + green + blue) / 3;
    }

    private int getRedFromPixel(int pixel) {
        return (pixel >> 16) & 0xff;
    }

    private int getBlueFromPixel(int pixel) {
        return (pixel >> 8) & 0xff;
    }

    private int getGreenFromPixel(int pixel) {
        return pixel & 0xff;
    }

    private char convertBrightness2Ascii(int brightness) {
        int asciiChar = (int) Math.round(brightness * PROPORTION);
        return ASCII_CHARS.charAt(asciiChar);
    }
}
