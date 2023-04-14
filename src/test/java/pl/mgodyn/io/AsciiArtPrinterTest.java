package pl.mgodyn.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.mgodyn.asciiart.io.AsciiArtPrinter;

import static org.junit.jupiter.api.Assertions.*;

class AsciiArtPrinterTest {

    private final AsciiArtPrinter underTest = new AsciiArtPrinter();

    @Test
    void givenChar_whenAdding2Row_shouldAddIt3Times() {
        // given
        final char ascii = '#';

        // when
        underTest.add2Row(ascii);

        // then
        final var expected = "###";
        assertEquals(expected, underTest.getCurrentBuffer());
    }

    @Test
    void afterPrintedRow_bufferShouldBeEmpty() {
        // given

        // when
        underTest.printRow();

        // then
        var expected = "";
        assertEquals(expected, underTest.getCurrentBuffer());
    }
}
