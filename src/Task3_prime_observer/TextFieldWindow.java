package Task3_prime_observer;

import javax.swing.*;
import java.awt.*;

public class TextFieldWindow extends FrameWindow implements Observer{

    private PrimeObservableThread primeObservableThread;
    private JTextField textField;
    private int primeNumber;
    private boolean observable = false;


    public TextFieldWindow(String title, int x, int y, int width, int height, PrimeObservableThread primeObservableThread) {

        super(title, x, y, width, height);
        this.primeObservableThread = primeObservableThread;

    }


    public void updateText(String msg) {
        textField.setText(msg);
        textField.validate();
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textField = new JTextField();
        panel.add(textField);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    @Override
    public boolean getstate() {//옵저버에 현재 상태를 반환하는 메소드
        return observable;
    }

    @Override
    public void remove(){
        primeObservableThread.rmOb(this);
        observable = false;
    }

    @Override
    public void register(){
        primeObservableThread.registeOb(this);
        observable = true;
    }


    @Override
    public void update(int primeNumber){
        this.primeNumber = primeNumber;
        updateText(""+primeNumber);
        //subject class에서 넘어온 값을 해당 객체에 저장함.
    }
}

