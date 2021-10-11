package org.eda.packlaboratorio1;

public class Stopwatch {

    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    /**
     * Return elapsed time (in seconds) since this object was created.
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}