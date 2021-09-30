package Algorithms;

import Graphics.ContentPanel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort extends SortAlgs {

    public MergeSort(ContentPanel c, int[] array)
    {
        super(c, array);
        c.setSort(this);
    }

    private void mergesort(int[] input, int offset)
    {
        if (input.length < 2) return;

        // Divide
        int mid = input.length / 2;

        int[] left = new int[mid];
        int[] right = new int[input.length - mid];

        for (int a = 0; a < mid; a++)
        {
            left[a] = input[a];
        }
        for (int b = mid; b < input.length; b++)
        {
            right[b - mid] = input[b];
        }

        mergesort(left, offset);
        mergesort(right, mid + offset);


        // Merge
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
        {
            pointer = k + offset;
            selector = k + offset;

            if (left[i] <= right[j])
            {
                input[k] = left[i];
                arrayToSort[k + offset] = left[i];
                pointer += i;
                i++;
            }
            else
            {
                input[k] = right[j];
                arrayToSort[k + offset] = right[j];
                selector += j;
                j++;
            }
            k++;

            cref.update(arrayToSort, 100);
        }

        while (i < left.length)
        {
            input[k] = left[i];
            arrayToSort[k + offset] = left[i];
            pointer = k + i + offset;
            k++;
            i++;
            cref.update(arrayToSort, 100);
        }
        while (j < right.length)
        {
            input[k] = right[j];
            arrayToSort[k + offset] = right[j];
            selector = k + j + offset;
            k++;
            j++;
            cref.update(arrayToSort, 100);
        }
        cref.update(arrayToSort, 100);
    }

    @Override
    public void run() {
        mergesort(arrayToSort, 0);
    }
}
