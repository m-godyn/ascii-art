package pl.mgodyn.asciiart.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class DefaultScreenSizeProvider implements ScreenSizeProvider {

    @Override
    public Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
