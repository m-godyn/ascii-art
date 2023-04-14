package pl.mgodyn.asciiart.io;

public class AsciiArtPrinter {

    private StringBuilder stringBuilder = new StringBuilder();

    public void add2Row(char ascii) {
        var toAppend = String.valueOf(ascii).repeat(3);
        stringBuilder.append(toAppend);
    }

    public void printRow() {
        System.out.println(stringBuilder);
        stringBuilder = new StringBuilder();
    }

    public String getCurrentBuffer() {
        return stringBuilder.toString();
    }
}
