package pl.mgodyn.asciiart.io;

public interface ImageHelper {

    void readImage(String imagePath);

    int getWidth();

    int getHeight();

    int getRGB(int x, int y);
}
