package pl.mgodyn.application;

import pl.mgodyn.domain.io.ImageReader;
import pl.mgodyn.domain.model.Image;
import pl.mgodyn.infrastructure.io.ImageReaderImpl;

import java.io.File;

class ImageReadingService {

    private final ImageReader imageReader = new ImageReaderImpl();

    Image readImage(final String imagePath) {
        return imageReader.read(new File(imagePath));
    }
}
