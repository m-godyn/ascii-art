package pl.mgodyn.infrastructure.converter;

import pl.mgodyn.domain.converter.BrightnessToAsciiConverter;

public class BrightnessToAsciiConverterImpl implements BrightnessToAsciiConverter {

    private static final String ASCII_CHARS = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
    private static final short MAX_POSSIBLE_BRIGHTNESS = 255;
    private static final double PROPORTION = (double) (ASCII_CHARS.length() - 1) / MAX_POSSIBLE_BRIGHTNESS;

    @Override
    public char convertToAscii(int brightness) {
        int asciiChar = (int) Math.round(brightness * PROPORTION);
        return ASCII_CHARS.charAt(asciiChar);
    }
}
