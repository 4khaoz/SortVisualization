package Graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentPanel extends JPanel implements ActionListener {

    private int[] arrayToDisplay;
    private Application appRef;

    public ContentPanel(Application app)
    {
        setMinimumSize(new Dimension(1000, 600));
        setPreferredSize(new Dimension(1200, 600));
        setBackground(Color.GRAY);
        appRef = app;
    }

    public void setArrayToDisplay(int[] array)
    {
        arrayToDisplay = array;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.CYAN);
        for (int i = 0; i < arrayToDisplay.length; i++)
        {
            int rect_height = (getHeight()/100) * arrayToDisplay[i];
            int rect_width = 40;
            int offset_side = 60;
            int rect_spacing = 100;

            g2d.fillRect(
                    rect_spacing * i + offset_side,
                    getHeight() - rect_height,
                    rect_width,
                    rect_height
            );
        }
    }

    public void startVisualization()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       repaint();
    }
}
