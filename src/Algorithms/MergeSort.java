package Algorithms;

import Graphics.ContentPanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MergeSort extends SortAlgs {

    private int sorted;
    private ArrayList<Integer> list;
    private boolean bSplitted;
    private int lsize;
    private int rsize;

    public MergeSort(ContentPanel c)
    {
        super(c);

        sorted = 0;
        bSplitted = false;
        list = new ArrayList<>();
    }

    private boolean mergesort(int[] input)
    {
        if (input.length < 2) return false;

        int mid = input.length / 2;

        int[] left = new int[mid];
        int[] right = new int[input.length - mid];

        for (int i = 0; i < mid; i++)
        {
            left[i] = input[i];
        }
        for (int j = mid; j < input.length; j++)
        {
            right[j - mid] = input[j];
        }

        mergesort(left);
        mergesort(right);


        int i = 0, j= 0, k = 0;
        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
            {
                input[k] = left[i];
                i++;
            }
            else
            {
                input[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length)
        {
            input[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length)
        {
            input[k] = right[j];
            k++;
            j++;
        }
        System.out.println(Arrays.toString(input));
        return true;
    }

    @Override
    public boolean Iterate(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
        if (sorted >= array.length)
        {
            System.out.println("Array: " + Arrays.toString(array));
            return true;
        }

        if (!bSplitted)
        {
            int len = array.length;
            do {
                len = len/2;
                list.add(len);
            }
            while (len > 1);
            bSplitted = true;
            System.out.println(Arrays.toString(list.toArray()));
        }

        if (list.size() > iteration)
        {
            lsize = list.get(list.size() - 1 - iteration);
            rsize = list.get(list.size() - 2 - iteration);
        }


        int[] left = new int[lsize];
        int[] right = new int[array.length -1];

        for (int i = 0; i < lsize; i++)
        {
            left[i] = array[i];
        }
        for (int j = lsize; j < rsize; j++)
        {
            right[j - lsize] = array[j];
        }

        // Merge Process
        pointer = 0;
        selector = 0;
        if (left[pointer] <= right[selector])
        {
            array[sorted] = left[pointer];
            pointer++;
        }
        else
        {
            array[sorted] = right[selector];
            selector++;
        }
        sorted++;

        /*

        while (pointer < left.length)
        {
            array[sorted] = left[pointer];
            sorted++;
            pointer++;
        }
        while (selector < right.length)
        {
            array[sorted] = right[selector];
            sorted++;
            selector++;
        }
         */

        return false;
    }
}
