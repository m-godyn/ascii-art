package pl.mgodyn.asciiart.io;

public class AsciiArtPrinter {

    private final StringBuilder stringBuilder = new StringBuilder();

    public void add2Row(char ascii) {
        var toAppend = String.valueOf(ascii).repeat(3);
        stringBuilder.append(toAppend);
    }

    public void createNewRow() {
        stringBuilder.append("\n");
    }

    public void print() {
        System.out.println(stringBuilder);
    }

    public String getCurrentBuffer() {
        return stringBuilder.toString();
    }
}
