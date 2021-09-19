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
public class SelectionSort {

    private int[] arrayToSort;

    /**
     * Constructor
     * @param array to sort
     */
    public SelectionSort(int[] array, ContentPanel c)
    {
        arrayToSort = array;
    }

    public int getIndexOfSmallestElement(int startIndex)
    {
        int index = startIndex;
        int minValue = arrayToSort[startIndex];
        for (int i = startIndex; i < arrayToSort.length; i++)
        {
            if (arrayToSort[i] < minValue)
            {
                index = i;
            }
        }
        return index;
    }
}
