package Graphics;

import Algorithms.BubbleSort;
import Algorithms.SelectionSort;
import Algorithms.SortAlgs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Application {

    private final ContentPanel cpanel;
    private final JPanel btnpanel;

    /* Utilities */
    private Timer timer;
    private SortAlgs sort;

    /* Default variables */
    private static final int window_width = 1280;
    private static final int window_height = 720;

    /* Array */
    private final int[] array;

    public Application()
    {
        JFrame window = new JFrame();
        window.setTitle("Visualization");
        window.setSize(window_width, window_height);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.PAGE_AXIS));
        window.setResizable(false);

        cpanel = new ContentPanel();
        btnpanel = new JPanel(new GridBagLayout());

        array = new int[12];
        generateRandomArray();
        cpanel.setArrayToDisplay(array);

        window.add(cpanel);
        window.add(btnpanel);

        setupButtons();
    }

    /**
     * Trigger ActionListener to update ContentPanel
     */
    public void updateCPanel()
    {
        cpanel.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    /**
     * Generates an array with 12 elements of random value
     */
    private void generateRandomArray()
    {
        for (int i = 0; i < array.length; i++)
        {
            // Random Integer from 1 to 100
            int x = (int) ((Math.random() * (100 - 1)) + 1);
            array[i] = x;
        }
        cpanel.setSort(null);
        System.out.println(Arrays.toString(array));
        updateCPanel();
    }

    /**
     * This method iterates the Visualization of the sorting algorithm
     * Should only be called by ActionListener through Button-Click
     */
    private void visualize()
    {
        if (sort.Iterate(array))
        {
            timer.stop();
        }
    }

    /**
     * Reset Visualization
     */
    private void stopVisualization()
    {
        if (timer != null)
        {
            timer.stop();
        }
        cpanel.setArrayToDisplay(array);
        updateCPanel();
    }

    private void setupButtons()
    {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.insets = new Insets(4, 4, 4, 8);

        Dimension btn_dimension = new Dimension(200, 20);

        // Generate new Array Button
        JButton generateArray_btn = new JButton("Generate new Array");
        generateArray_btn.setPreferredSize(btn_dimension);
        generateArray_btn.addActionListener(e -> generateRandomArray());
        c.gridx = 0;
        c.gridy = 0;
        btnpanel.add(generateArray_btn, c);

        // Reset Visualization Button
        JButton reset_btn = new JButton("Reset");
        reset_btn.setPreferredSize(btn_dimension);
        reset_btn.addActionListener(e -> stopVisualization());
        c.gridx = 0;
        c.gridy = 1;
        btnpanel.add(reset_btn, c);

        // Selection Sort Button
        JButton selection_btn = new JButton("Selection Sort");
        selection_btn.setPreferredSize(btn_dimension);
        selection_btn.addActionListener(e -> {
            sort = new SelectionSort(cpanel);
            timer = new Timer(500, ex -> visualize());
            timer.setRepeats(true);
            timer.start();
        });
        c.gridx = 1;
        c.gridy = 0;
        btnpanel.add(selection_btn, c);

        // Bubble Sort Button
        JButton bubble_btn = new JButton("Bubble Sort");
        bubble_btn.setPreferredSize(btn_dimension);
        bubble_btn.addActionListener(e -> {
            sort = new BubbleSort(cpanel);
            timer = new Timer(500, ex -> visualize());
            timer.setRepeats(true);
            timer.start();
        });
        c.gridx = 1;
        c.gridy = 1;
        btnpanel.add(bubble_btn, c);
    }
}
