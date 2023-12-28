package com.watch.store.view;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public String readInput() {
        return scanner.next();
    }

}
