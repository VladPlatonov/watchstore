package com.watch.store.factory;

import com.watch.store.model.Watch;

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
     * Creates a new Watch instance by prompting the user to provide necessary information using the
     * Scanner.
     *
     * @return the created Watch instance
     */
    Watch createWatch();
}
