package Algorithms;

import Graphics.ContentPanel;

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

    public SelectionSort(ContentPanel c, int[] array)
    {
        super(c, array);
        c.setSort(this);
    }

    /**
     * Implementation of Selection Sort
     * @param array array to sort
     */
    private void selectionSort(int[] array)
    {
        // Iterate through array
        for (iteration = 0; iteration < array.length - 1; iteration++)
        {
            // Find the minimum in unsorted array
            pointer = iteration;
            for (selector = pointer+1; selector < array.length; selector++)
            {
                if (array[selector] < array[pointer])
                    pointer = selector;

                cref.update(array, 100);
            }

            // Swap minimum with first unsorted element
            int temp = array[iteration];
            array[iteration] = array[pointer];
            array[pointer] = temp;
            sortedIndices[iteration] = true;

            cref.update(array, 100);
        }

        System.out.println("Finished");
    }

    @Override
    public void run() {
        selectionSort(arrayToSort);
    }
}
