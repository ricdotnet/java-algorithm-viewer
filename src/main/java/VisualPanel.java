import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class VisualPanel extends JPanel {

    Numbers numbers = new Numbers();
    int[] sortedArray;
    int numToFind = 0;

    public VisualPanel() {
        setSize(new Dimension(350, 280));
        setLocation(0, 70);
        setBackground(new Color(132, 159, 219));

        init();
    }

    private void init() {
        numbers.addNumbers();
        generateArray();
        System.out.println(Arrays.toString(sortedArray));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderBars(g);

        if(numToFind > 0) {
            paintBar(g);
        }
    }

    private void renderBars(Graphics g) {
        g.setColor(Color.BLACK);

        int pos = 0;
        for(int i = 0; i < 54; i++) {
            pos = pos + 6;
            g.drawRect(pos, (180-sortedArray[i]) + 50, 4, sortedArray[i]);
            g.fillRect(pos, (180-sortedArray[i]) + 50, 4, sortedArray[i]);
        }
    }

    private void paintBar(Graphics g) {

        g.setColor(Color.GREEN);

        int pos = 0;
        for(int i = 0; i < 54; i++) {
            pos = pos + 6;
            if(sortedArray[i] == numToFind) {
                g.drawRect(pos, (180 - sortedArray[i]) + 50, 4, sortedArray[i]);
                g.fillRect(pos, (180 - sortedArray[i]) + 50, 4, sortedArray[i]);
            }
        }
    }

    public void generateArray() {
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

    public void sort2() {
        int[] sortedArray2 = sortedArray;
        for(int i = 0; i < sortedArray.length; i++) {
            for(int j = i; j < sortedArray.length; j++) {
                if(sortedArray2[j] < sortedArray2[i]) {
                    int temp = sortedArray2[j];
                    for(int x = j; x > i; x--) {
                        sortedArray2[x] = sortedArray2[x-1];
                    }
                    sortedArray2[i] = temp;
                    return;
                }
            }
        }
    }

    public void findMax() {
        for(int number:sortedArray) {
            if(number > numToFind) {
                numToFind = number;
            }
        }
    }

    public void findMin() {
        numToFind = sortedArray[0];
        for(int number:sortedArray) {
            if(number < numToFind) {
                numToFind = number;
            }
        }
    }
}
