package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

public class MainPanel {

    private JFrame window= new JFrame("Erlenmeyer flask");
    CenterPanel panel_01= new CenterPanel();
    JPanel panel_02=new JPanel();
    JButton fillButton =new CustomButton("Fill");
    JButton drainButton=new CustomButton("Drain");

    private static MainPanel panelObj;

    private MainPanel(){
        panel_01.setBackground(Color.decode("#cbccc6"));
        panel_02.setBackground(Color.decode("#273c50"));

        panel_02.add(drainButton);
        panel_02.add(Box.createRigidArea(new Dimension(100,0)));
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

        window.setSize(600,800);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);    }

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

    /*CustomButton class was created to add customised buttons for Fill and Drain */

    class CustomButton extends JButton implements MouseListener{
        Font defaultFont = new Font("Tahoma",Font.PLAIN,30);
        Color textColor = Color.decode("#ffffff");
        Color fillBackgroundColor = Color.decode("#428bca");
        Color drainBackgroundColor = Color.decode("#b62a25");
        Color backgroundColor;
        Color fillHoverColor = Color.decode("#5bc0de");
        Color drainHoverColor = Color.decode("#ec3c3c");
        Color hoverColor;

        public CustomButton(String s) {
            s = s.toUpperCase();
            this.setFocusPainted(false);
            this.setText(s);
            this.setBorder(null);
            this.setForeground(textColor);
            if(s.equals("FILL")){
                backgroundColor = fillBackgroundColor;
                hoverColor =fillHoverColor;
            } else {
                backgroundColor = drainBackgroundColor;
                hoverColor = drainHoverColor;
            }
            this.setBackground(backgroundColor);
            this.setFont(defaultFont);
            this.setOpaque(true);
            this.setPreferredSize(new Dimension(150, 80));
            addMouseListener(this);
        }

        public void setBackgroundColor(Color color) {
            backgroundColor = color;
        }
        public void setHoverColor(Color color) {
            hoverColor = color;
        }

        @Override public void mouseClicked(MouseEvent me) {}
        @Override public void mouseReleased(MouseEvent me) {}
        @Override public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource()==this) {
                this.setBackground(this.hoverColor);
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource()==this) {
                this.setBackground(this.backgroundColor);
            }
        }
    }
}
