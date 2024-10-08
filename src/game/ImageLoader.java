package game;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {
    private static final Map<String, ImageIcon> imageCache = new HashMap<>();

    public static ImageIcon loadImage(String path) {
        // Check if the image is already in the cache
        if (imageCache.containsKey(path)) {
            return imageCache.get(path);
        }

        // Load the image
        ImageIcon icon = new ImageIcon(ImageLoader.class.getResource(path));

        // Check if the image was loaded successfully
        if (icon.getIconWidth() == -1) {
            System.err.println("Image not found at path: " + path);
        } else {
            // Cache the loaded image
            imageCache.put(path, icon);
        }

        return icon;
    }
}
