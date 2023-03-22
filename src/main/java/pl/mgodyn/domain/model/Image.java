package pl.mgodyn.domain.model;

public record Image(int width, int height, Pixel[][] pixels) {

    public void printSize() {
        System.out.printf("Image size: %s x %s%n", width, height);
    }
}