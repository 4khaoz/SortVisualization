package Graphics;

import Algorithms.SortAlgs;

import javax.swing.JPanel;
import java.awt.*;

public class ContentPanel extends JPanel {

    private int[] arrayToDisplay;
    private SortAlgs sort;

    public ContentPanel()
    {
        setMinimumSize(new Dimension(1280, 600));
        setPreferredSize(new Dimension(1280, 600));
        setBackground(Color.GRAY);
    }

    public void setArrayToDisplay(int[] array)
    {
        arrayToDisplay = array;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < arrayToDisplay.length; i++)
        {
            int rect_height = (getHeight()/100) * arrayToDisplay[i];
            int rect_width = getWidth() / arrayToDisplay.length;

            g2d.setColor(Color.CYAN);
            // If Sort Visualization in Progress, set Colors
            if (sort != null)
            {
                if (sort.isIndexSorted(i))
                {
                    // Sorted elements
                    g2d.setColor(Color.BLUE);
                }
                else if (i == sort.getPointer())
                {
                    g2d.setColor(Color.MAGENTA);
                }
                else if (i == sort.getSelector())
                {
                    g2d.setColor(Color.RED);
                }
            }

            g2d.fillRect(
                    rect_width * i,
                    getHeight() - rect_height,
                    rect_width,
                    rect_height
            );
        }
    }

    public void setSort(SortAlgs s)
    {
        sort = s;
    }

    public void update(int[] array, long msDelay)
    {
        setArrayToDisplay(array);

        delay(msDelay);
        repaint();
    }

    private void delay(long msDelay)
    {
        repaint();
        try {
            Thread.sleep(msDelay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
