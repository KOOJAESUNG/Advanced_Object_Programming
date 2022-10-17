package Task4_Decorator_Pattern;

import javax.swing.*;

public abstract class DisplayDecorator extends Display {
    Display display;
    DisplayDecorator(Display display, int width, int height) {
        super(width, height);
    }
}

