package Sweet.System;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        try {
            SweetSystem app = new SweetSystem();
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
