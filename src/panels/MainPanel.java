package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPanel {

    private JFrame window= new JFrame("Multiple panels.MainPanel");
    CenterPanel panel_01= new CenterPanel();
    JPanel panel_02=new JPanel();
    JButton fillButton =new JButton("Fill");
    JButton drainButton=new JButton("Drain");

    private static MainPanel panelObj;

    private MainPanel(){
        panel_01.setBackground(Color.CYAN);
        panel_02.setBackground(Color.DARK_GRAY);

        panel_02.add(drainButton);
        panel_02.add(fillButton);

        window.add(panel_01,BorderLayout.CENTER);
        window.add(panel_02,BorderLayout.PAGE_END);


        fillButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                panel_01.startAction(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panel_01.stopAction();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

        });
        drainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                panel_01.startAction(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panel_01.stopAction();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        window.setSize(500,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static MainPanel getPanel(){

        if (panelObj == null) {
            synchronized (MainPanel.class) {
                if (panelObj == null) {
                    panelObj = new MainPanel();//instance will be created at request time
                }
            }
        }
        return panelObj;
    }
}
