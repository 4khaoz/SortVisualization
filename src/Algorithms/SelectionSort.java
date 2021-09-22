package Algorithms;

import Graphics.ContentPanel;

import java.awt.event.ActionEvent;

/**
 * Selection-Sort
 * 1. Iterates through given array to find the smallest unsorted element
 * 2. Swap place of found minimum element and first free array slot
 * 3. This process is repeated until all array slots are locked
 *
 * Runtime: O(n^2)
 */
public class SelectionSort extends SortAlgs{

    int min;

    public SelectionSort(ContentPanel c)
    {
        super(c);
        cref.setSort(this);
        pointer = 0;
        selector = 0;
    }

    /**
     * Implementation of Selection Sort as a step-by-step task for Timer
     * Each call of this function is one step of the algorithm
     * @param array Array to sort
     * @return true if sort finished, false to continue sort algorithm
     */
    @Override
    public boolean Iterate(int[] array)
    {
        if (iteration >= array.length)
        {
            System.out.println("Finished");
            return true;
        }

        // Start Next iteration
        if (selector == iteration)
        {
            min = array[iteration];
            pointer = iteration;
        }

        // New minimum Value found
        if (array[selector] < min)
        {
            min = array[selector];
            pointer = selector;
        }

        selector++;

        // End of iteration, sort
        if (selector >= array.length)
        {
            array[pointer] = array[iteration];
            array[iteration] = min;
            sortedIndices[iteration] = true;
            iteration++;
            selector = iteration;
        }

        // Update Content Panel
        cref.setArrayToDisplay(array);
        cref.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        return false;
    }
}
