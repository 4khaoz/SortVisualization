package Graphics;

import Algorithms.BubbleSort;
import Algorithms.MergeSort;
import Algorithms.SelectionSort;
import Algorithms.SortAlgs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;


public class Application {

    /* Default variables */
    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;

    private final ContentPanel cpanel;
    private final JPanel btnpanel;

    /* Utilities */
    private Thread sortThread;

    /* Array */
    private final int[] array;

    public Application()
    {
        JFrame window = new JFrame();
        window.setTitle("Visualization");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.PAGE_AXIS));
        window.setResizable(false);

        cpanel = new ContentPanel();
        btnpanel = new JPanel(new GridBagLayout());

        array = new int[36];
        generateRandomArray();
        cpanel.setArrayToDisplay(array);

        window.add(cpanel);
        window.add(btnpanel);

        setupButtons();
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
        cpanel.setArrayToDisplay(array);
        cpanel.repaint();
    }

    /**
     * Reset Visualization
     */
    private void stopVisualization()
    {
        cpanel.setArrayToDisplay(array);
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
            sortThread = new Thread(new SelectionSort(cpanel, array));
            sortThread.start();
        });
        c.gridx = 1;
        c.gridy = 0;
        btnpanel.add(selection_btn, c);

        // Bubble Sort Button
        JButton bubble_btn = new JButton("Bubble Sort");
        bubble_btn.setPreferredSize(btn_dimension);
        bubble_btn.addActionListener(e -> {
            sortThread = new Thread(new BubbleSort(cpanel, array));
            sortThread.start();
        });
        c.gridx = 1;
        c.gridy = 1;
        btnpanel.add(bubble_btn, c);

        // Merge Sort Button
        JButton merge_btn = new JButton("Merge Sort");
        merge_btn.setPreferredSize(btn_dimension);
        merge_btn.addActionListener(e -> {
            sortThread = new Thread(new MergeSort(cpanel, array));
            sortThread.start();
        });
        c.gridx = 2;
        c.gridy = 0;
        btnpanel.add(merge_btn, c);
    }
}
