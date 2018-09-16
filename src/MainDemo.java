import panels.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainDemo {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                MainPanel.getPanel();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(),"Cannot Start The Program Due to Some Unknown Error", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

        });
    }
}
