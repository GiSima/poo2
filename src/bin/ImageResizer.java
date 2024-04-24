package bin;

import java.awt.Image;
import java.net.URL;
import java.util.Objects;
import javax.swing.ImageIcon;

public class ImageResizer {

    public static ImageIcon resizeImage(String imagePath, int newWidth, int newHeight) {
        URL imageUrl = ImageResizer.class.getResource(imagePath);
        if (imageUrl == null) {
            System.err.println("Imagem não encontrada: " + imagePath);
            return new ImageIcon(); // Retorna uma ImageIcon vazia para evitar NullPointerException
        }
        ImageIcon originalIcon = new ImageIcon(imageUrl);
        Image originalImage = originalIcon.getImage();

        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}
