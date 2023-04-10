package pl.mgodyn.domain.model;

public record AsciiArt(char[][] matrix) {

    public void print() {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.printf("%s", value);
            }
            System.out.println();
        }
    }
}
