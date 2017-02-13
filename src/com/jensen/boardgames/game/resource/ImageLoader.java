package com.jensen.boardgames.game.resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * A singleton resource loader for images, which can cache the images.
 */
public class ImageLoader implements ResourceLoader<Image> {

    private static ImageLoader instance;
    private Map<URL, Image> imageCache = new HashMap<URL, Image>();

    private ImageLoader() {}

    /**
     * Gets the singleton instance.
     *
     * @return The instance.
     */
    public static synchronized ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }

        return instance;
    }

    /**
     * Loads an image.
     *
     * @param path The path of the image.
     * @return An image.
     */
    public Image load(String path) {
        return load(path, false);
    }

    /**
     * Loads an image and can cache it.
     *
     * @param path The path of the image.
     * @param cache Determines whether the image should be cached.
     * @return An image.
     */
    public Image load(String path, boolean cache) {
        URL url = getClass().getResource(path);

        if (url == null) {
            throw new RuntimeException("Can't find resource: " + path);
        }

        Image image = null;

        if (cache) {
            image = imageCache.get(url);
        }

        if (image == null) {
            try {
                image = ImageIO.read(url);
            } catch (IOException e) {
                throw new RuntimeException("Can't parse image: " + path);
            }

            if (cache) {
                imageCache.put(url, image);
            }
        }

        return image;
    }
}
