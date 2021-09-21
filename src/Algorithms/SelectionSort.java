package Algorithms;

import Graphics.ContentPanel;

import java.awt.event.ActionEvent;
import java.util.Arrays;


/**
 * Selection-Sort
 * 1. Iterates through given array to find the smallest unsorted element
 * 2. Swap place of found minimum element and first free array slot
 * 3. This process is repeated until all array slots are locked
 *
 * Runtime: O(n^2)
 */
public class SelectionSort extends SortAlgs{

    public SelectionSort(ContentPanel c)
    {
        cref = c;
        cref.setSort(this);
        iteration = 0;
    }

    /**
     * Implementation of Selection Sort as repeatable task for Timer
     * @param array Array to sort
     * @return true if sort finished, false to continue sort algorithm
     */
    public boolean Iterate(int[] array)
    {
        if (iteration >= array.length)
        {
            System.out.println("Finished");
            return true;
        }
        int min = array[iteration];
        int pointer = iteration;

        // TODO: Rewrite for-loop into steps to visualize the iteration steps
        for (int i = iteration; i < array.length; i++)
        {
            if (array[i] < min)
            {
                min = array[i];
                pointer = i;
            }
        }
        array[pointer] = array[iteration];
        array[iteration] = min;

        iteration++;

        // Update Content Panel
        cref.setArrayToDisplay(array);
        cref.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        return false;
    }
}
