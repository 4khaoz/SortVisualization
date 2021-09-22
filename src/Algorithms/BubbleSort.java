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

    public BubbleSort(ContentPanel c)
    {
        super(c);
        cref.setSort(this);
        pointer = 0;
        selector = 1;
        sorted = false;
    }

    /**
     * Implementation of Bubble Sort as a step-by-step task for Timer
     * Each call of this function is one step of the algorithm
     * @param array Array to sort
     * @return true if sort finished, false to continue sort algorithm
     */
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
        cref.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        return false;
    }
}
