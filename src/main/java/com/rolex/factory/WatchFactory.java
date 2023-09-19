package com.rolex.factory;

import com.rolex.model.watches.Watch;
import java.util.Scanner;

/**
 * An interface representing a factory for creating watch objects of a specific type.
 */
public interface WatchFactory {

    /**
     * Returns the type of watch that this factory creates.
     *
     * @return a String containing the watch type
     */
    String getWatchType();

    /**
     * Creates a new Watch instance by prompting the user to provide necessary information using the Scanner.
     *
     * @param scanner the Scanner used for reading input data from the user
     * @return the created Watch instance
     */
    Watch createWatch(Scanner scanner);
}
