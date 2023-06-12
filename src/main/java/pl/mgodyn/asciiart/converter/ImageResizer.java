package pl.mgodyn.asciiart.converter;

public interface ImageResizer<T> {

    T resize(T image);

    int getScreenSizeWidth();
}
