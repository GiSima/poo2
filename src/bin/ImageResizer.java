package bin;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageResizer {

    public static ImageIcon resizeImage(String imagePath, int newWidth, int newHeight) {
    try {
        File path = new File(imagePath);
        Image image = ImageIO.read(path);

        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);

    } catch (IOException ex) {
        ex.printStackTrace();
        return new ImageIcon();
    }

//        URL imageUrl = URL.class.getResource(imagePath);
//        if (imageUrl == null) {
//            System.err.println("Imagem não encontrada: " + imagePath);
//            return new ImageIcon(); // Retorna uma ImageIcon vazia para evitar NullPointerException
//        }
//        ImageIcon originalIcon = new ImageIcon(imageUrl);
//        Image originalImage = originalIcon.getImage();
//
//        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//        return new ImageIcon(scaledImage);
    }
}
