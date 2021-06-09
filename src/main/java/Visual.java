import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visual extends JFrame implements ActionListener {

    static Visual visual = new Visual();
//    JPanel visualPanel = new JPanel();
    JButton startButton = new JButton();
    VisualPanel visualPanel = new VisualPanel();
    Numbers numbers = new Numbers();
    private Timer timer;

    public static void main(String args[]) {
        visual.init();
    }

    public void init() {
        timer = new Timer(500, this);
        setSize(350, 350);
        setMinimumSize(new Dimension(350, 350));
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //visual panel
//        visualPanel.setBackground(new Color(56, 73, 110));
//        visualPanel.setSize(new Dimension(350, 300));
//        visualPanel.setLocation(0, 50);

        //start button
        startButton.setText("Start");
        startButton.setSize(100, 30);
        startButton.setLocation((350/2) - 55, 10);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                visualPanel.sort();
                visualPanel.repaint();
            }
        });

        add(visualPanel);
        add(startButton);
        pack();
        setVisible(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(visualPanel.sorting)
            System.out.println("sldkjfsdf");
    }
}
