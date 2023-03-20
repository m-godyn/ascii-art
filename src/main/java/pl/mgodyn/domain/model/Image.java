package pl.mgodyn.domain.model;

public record Image(int width, int height, Pixel[][] pixels) {

    public void printSize() {
        System.out.printf("Image size: %s x %s%n", width, height);
    }

    public void printPixels() {
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                System.out.println(pixels[y][x].toString());
            }
        }
    }
}