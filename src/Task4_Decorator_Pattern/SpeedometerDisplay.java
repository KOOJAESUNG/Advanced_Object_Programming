package Task4_Decorator_Pattern;

import javax.swing.*;
import java.awt.*;

public class SpeedometerDisplay extends DisplayDecorator{
    JPanel panel;
    LabelPanel labelPanel;

    public SpeedometerDisplay(Display display, int width, int height){
        super(display, width, height);
        this.display = display;
    }

    @Override
    public JPanel create() {
        // 레이블을 담을 패널 생성
        panel = new JPanel();
        // 레이블 또는 다른 패널이 추가될 때 세로 방향으로 나열되도록 레이아웃 설정
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // 문자열을 보일 레이블 생성
        labelPanel = new LabelPanel();
        // 패널에 레이블을 붙임.
        panel.add(display.create());
        panel.add(labelPanel.createPanel(getWidth(), getHeight()));
        return panel;
    }

    @Override
    public void show() {
        display.show();
        labelPanel.updateText("speed: 50");
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

}
