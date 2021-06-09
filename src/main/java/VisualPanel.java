import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class VisualPanel extends JPanel {

    Numbers numbers = new Numbers();
    int[] sortedArray;
    public Boolean sorting = false;

    public VisualPanel() {
        setSize(new Dimension(350, 300));
        setLocation(0, 50);
        setBackground(new Color(132, 159, 219));

        init();
    }

    private void init() {
        numbers.addNumbers();
        generateArray();
        System.out.println(Arrays.toString(sortedArray));

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                System.out.println("lksdjf");
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderBars(g);
    }

    private void renderBars(Graphics g) {
        g.setColor(Color.BLACK);

        int pos = 0;
        for(int i = 0; i < 54; i++) {
            pos = pos + 6;
            g.drawRect(pos, (200-sortedArray[i]) + 50, 4, sortedArray[i]);
            g.fillRect(pos, (200-sortedArray[i]) + 50, 4, sortedArray[i]);
        }
    }

    public void generateArray() {
//        int[] tempArray = new int[numbers.printNumbers().length];
//        tempArray = numbers.printNumbers();
        sortedArray = numbers.printNumbers();
    }

    public void sort() {
        for(int i = 0; i < sortedArray.length; i++) { //number of steps to loop (set from the number of elements in the array)
            for(int j = 1; j < sortedArray.length; j++) { //number of checks to check the larger number
                if(sortedArray[j - 1] > sortedArray[j]) { //if the number on the left is larger than the number on the right
                    int temp = sortedArray[j - 1]; //set a temporary number with the larger number
                    //swap both numbers
                    sortedArray[j - 1] = sortedArray[j]; //set the left element as the smallest
                    sortedArray[j] = temp; //set the right element as the largest
                    return;
                }
            }
        }
        System.out.println("Finished sorting: " + Arrays.toString(sortedArray));
    }
}
