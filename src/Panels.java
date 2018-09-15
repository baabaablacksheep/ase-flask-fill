import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panels implements ActionListener {
    JFrame window= new JFrame("Multiple Panels");
    DrawPanel panel_01=new DrawPanel();
    JPanel panel_02=new JPanel();
    JButton fillButton =new JButton("Fill");
    JButton drainButton=new JButton("Drain");
    JLabel infoTextFilled=new JLabel("Container Filled!");
    JLabel infoTextDrained=new JLabel("Container Emptied!");

    Panels(){
        panel_01.setBackground(Color.CYAN);
        panel_02.setBackground(Color.DARK_GRAY);

        panel_01.add(infoTextFilled);
        panel_01.add(infoTextDrained);

        panel_02.add(drainButton);
        panel_02.add(fillButton);

        window.add(panel_01,BorderLayout.CENTER);
        window.add(panel_02,BorderLayout.PAGE_END);

        fillButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //panel_01.startFill(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panel_01.startFill(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panel_01.stopFill(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        drainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                panel_01.startDrain(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panel_01.stopDrain(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        infoTextFilled.setVisible(false);

        window.setSize(500,800);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(fillButton)){
            infoTextFilled.setVisible(true);
            infoTextDrained.setVisible(false);
            panel_01.setBackground(Color.LIGHT_GRAY);
            panel_02.setBackground(Color.LIGHT_GRAY);

        }
        else{
            infoTextFilled.setVisible(false);
            infoTextDrained.setVisible(true);
            panel_01.setBackground(Color.CYAN);
            panel_02.setBackground(Color.DARK_GRAY);

        }


    }
}
