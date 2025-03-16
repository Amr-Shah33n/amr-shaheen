package org.moneyapp;

public interface ScreenManager {

     static <T> T on(Class<T> screenClass, boolean isLoaded){
        try {
             return screenClass.getConstructor(boolean.class).newInstance(isLoaded);
        } catch (Exception e) {
            throw new RuntimeException(screenClass.getSimpleName() + " could not be created");
        }
    }
}
