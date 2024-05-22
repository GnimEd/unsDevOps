import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.Mat;

public class CameraExample {
    public static void main(String[] args) {
        // Ouvrir la webcam (vous devez avoir OpenCV installé)
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Webcam webcam = Webcam.getDefault();
        webcam.open();

        // Capturer une image
        BufferedImage image = webcam.getImage();

        // Enregistrer l'image dans un fichier (par exemple, au format PNG)
        try {
            ImageIO.write(image, "PNG", new File("webcam_image.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Afficher l'image dans une fenêtre (vous pouvez personnaliser cela)
        JFrame frame = new JFrame("Webcam Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }
}

