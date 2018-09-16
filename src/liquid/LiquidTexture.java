package liquid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LiquidTexture {

    private BufferedImage liquidImg;

    public LiquidTexture(){
        loadImages();

    }

    private void loadImages() {

        try {

            liquidImg = ImageIO.read(new File("./resources/liquid_texture.jpg"));

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(new JFrame(),"Could not load images", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public TexturePaint getTexture(){
        return new TexturePaint(liquidImg, new Rectangle(0, 0, 250, 500));

    }
}
