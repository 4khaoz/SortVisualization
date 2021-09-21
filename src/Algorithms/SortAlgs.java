package Algorithms;

import Graphics.ContentPanel;

public abstract class SortAlgs {

    protected ContentPanel cref;
    protected int iteration;

    public int getIteration() {
        return iteration;
    }

    public abstract boolean Iterate(int[] array);
}
