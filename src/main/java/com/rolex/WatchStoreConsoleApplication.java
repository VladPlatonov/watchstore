package com.rolex;

import com.rolex.config.AppConfiguration;
import com.rolex.util.WatchStoreMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WatchStoreConsoleApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AppConfiguration.class);
        context.getBean(WatchStoreMenu.class).runMenu();
    }

}
