package com.rolex.handler;

/**
 * An interface representing a generic menu handler for menu-driven applications.
 */
public interface MenuHandler {

    /**
     * Executes the action associated with the menu option.
     */
    void handle();

    /**
     * Returns a description of the menu option that this handler represents.
     *
     * @return a String containing the menu option description
     */
    String getMenuDescription();

}
