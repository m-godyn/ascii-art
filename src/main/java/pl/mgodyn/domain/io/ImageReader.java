package pl.mgodyn.domain.io;

import pl.mgodyn.domain.model.Image;

import java.io.File;

public interface ImageReader {

    Image read(File image);
}
