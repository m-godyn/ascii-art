package pl.mgodyn.model;

public record Image(int width, int height) {

    public void printSize() {
        System.out.printf("Image size: %s x %s%n", width, height);
    }
}