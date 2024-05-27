import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visual extends JFrame {

    static Visual visual = new Visual();
    static Numbers numbers = new Numbers();
    VisualPanel visualPanel = new VisualPanel();

    JButton startButton = new JButton();
    JButton resetButton = new JButton();
    JButton chooseTypeOfSort = new JButton();
    JButton findMax = new JButton();
    JButton findMin = new JButton();

    static int typeOfSort = 0;

    public static void main(String[] args) {
        visual.init();
    }

    public void init() {
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
        startButton.setText("Sort 1 Bar");
        startButton.setSize(100, 20);
        startButton.setLocation(10, 10);
        resetButton.setText("New Array");
        resetButton.setSize(100, 20);
        resetButton.setLocation(120, 10);
        chooseTypeOfSort.setText(String.valueOf(typeOfSort));
        chooseTypeOfSort.setSize(45, 20);
        chooseTypeOfSort.setLocation(getWidth() - 70, 10);
        findMax.setText("Find Max");
        findMax.setSize(100, 20);
        findMax.setLocation(10, 40);
        findMin.setText("Find Min");
        findMin.setSize(100, 20);
        findMin.setLocation(120, 40);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                visualPanel.repaint();

                if(typeOfSort == 0) {
                    visualPanel.sort();
                } else if(typeOfSort == 1) {
                    visualPanel.sort2();
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                numbers.addNumbers();
                visualPanel.generateArray();
                visualPanel.repaint();
                visualPanel.numToFind = 0;
            }
        });
        chooseTypeOfSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(typeOfSort == 0) {
                    typeOfSort = 1;
                } else {
                    typeOfSort = 0;
                }
                chooseTypeOfSort.setText(String.valueOf(typeOfSort));
            }
        });
        findMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                visualPanel.numToFind = 0;
                visualPanel.findMax();
                visualPanel.repaint();
            }
        });
        findMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                visualPanel.numToFind = 0;
                visualPanel.findMin();
                visualPanel.repaint();
            }
        });

        add(visualPanel);
        add(startButton);
        add(resetButton);
        add(chooseTypeOfSort);
        add(findMax);
        add(findMin);
        pack();
        setVisible(true);
    }

}
