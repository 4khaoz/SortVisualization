package Algorithms;

import Graphics.ContentPanel;

public abstract class SortAlgs implements Runnable {

    protected ContentPanel cref;
    protected boolean[] sortedIndices;
    protected int[] arrayToSort;

    public SortAlgs(ContentPanel c, int[] array)
    {
        cref = c;
        arrayToSort = array;
        iteration = 0;
        sortedIndices = new boolean[array.length];
    }

    /*
    Private Variables to save values for instance since
    Iteration is made step by step per call instead of full sort-loop
    iteration   = iteration count
    pointer     = index of element to be sorted
    selector    = index of element looked at
     */
    protected int iteration;
    protected int pointer;
    protected int selector;

    public int getPointer()
    {
        return pointer;
    }

    public int getSelector() {
        return selector;
    }

    public boolean isIndexSorted(int i)
    {
        return sortedIndices[i];
    }
}
