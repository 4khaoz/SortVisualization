package Algorithms;

import Graphics.ContentPanel;

import java.awt.event.ActionEvent;

/**
 * Bubble-Sort
 * 1. Iterates through array and compares i and j=i+1
 * 2. If i > j swap elements
 * 3. If one iteration doesn't have swaps, than array is sorted
 *
 * Runtime: O(n^2)
 */
public class BubbleSort extends SortAlgs {

    private boolean sorted;

    public BubbleSort(ContentPanel c, int[] array)
    {
        super(c, array);
        cref.setSort(this);
        pointer = 0;
        selector = 1;
        sorted = false;
    }

    /**
     * Implementation of Bubble Sort
     * @param array Array to sort
     */
    private void bubbleSort(int[] array)
    {
        for (iteration = 0; iteration < array.length; iteration++)
        {
            for (pointer = 0; pointer < array.length - iteration - 1; pointer++)
            {
                selector = pointer + 1;
                if (array[pointer] > array[selector])
                {
                    int temp = array[pointer];
                    array[pointer] = array[selector];
                    array[selector] = temp;
                }
                cref.update(array, 100);
            }
            sortedIndices[array.length - iteration - 1] = true;
        }
        cref.update(array, 100);
    }

    /*
    @Override
    public boolean Iterate(int[] array) {
        if (sorted)
        {
            System.out.println("Finished");
            return true;
        }


        // Comparison
        if (array[pointer] > array[selector])
        {
            int temp = array[pointer];
            array[pointer] = array[selector];
            array[selector] = temp;
        }

        pointer++;
        selector++;

        // End of iteration
        if (selector >= array.length - iteration)
        {
            iteration++;
            if (iteration > array.length)
            {
                System.out.println("Finished");
                return true;
            }
            sortedIndices[array.length - iteration] = true;
            pointer = 0;
            selector = 1;
        }

        // Update Content Panel
        cref.setArrayToDisplay(array);

        return false;
    }

     */

    @Override
    public void run() {
        bubbleSort(arrayToSort);
    }
}
