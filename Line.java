package org.shenmeng;

public class Line implements MainMenu{

    public static void line() {
        int line = 1;
        while (line <= 120) {
            System.out.printf("%c", 45);
            line++;
        }
    }
}
