package Algorithms;

import Graphics.ContentPanel;

public abstract class SortAlgs {

    protected ContentPanel cref;
    protected boolean[] sortedIndices;

    public SortAlgs(ContentPanel c)
    {
        cref = c;
        iteration = 0;
        sortedIndices = new boolean[12];
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

    public int getIteration() {
        return iteration;
    }

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

    public abstract boolean Iterate(int[] array);
}
