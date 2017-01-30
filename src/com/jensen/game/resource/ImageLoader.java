package com.jensen.game.resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader implements ResourceLoader<Image> {

    private static ImageLoader instance;
    private Map<URL, Image> imageCache = new HashMap<URL, Image>();

    private ImageLoader() {}

    public static synchronized ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }

        return instance;
    }

    public Image load(String path) {
        return load(path, false);
    }

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
