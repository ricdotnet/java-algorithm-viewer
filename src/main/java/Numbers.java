import java.util.Arrays;

public class Numbers {

    private static final int[] numbers = new int[54];

//    public static void main(String args[]) {
//
//        Numbers numbers = new Numbers();
//
//        numbers.addNumbers();
//        System.out.println(Arrays.toString(numbers.printNumbers()));
//
////        numbers.findMax();
////        numbers.findMin();
//        numbers.sort();
//    }

    public int[] printNumbers() {
        return numbers;
    }

    public void addNumbers() {
        for(int i = 0; i < 54; i++) {
            numbers[i] = (int) Math.ceil(Math.random() * 200);
        }
    }

    public int printNumber(int index) {
        return numbers[index];
    }

    public void findMax() {
        int max = numbers[0];
        for(int number:numbers) {
            if(number > max) {
                max = number;
            }
        }

        System.out.println(max);
    }

    public void findMin() {
        int min = numbers[0];
        for(int number:numbers) {
            if(number < min) {
                min = number;
            }
        }

        System.out.println(min);
    }

    public void sort() {
        int[] tempArray = numbers; //initialize a copy temporary array from the main array

        for(int i = 0; i < numbers.length; i++) { //number of steps to loop (set from the number of elements in the array)

            for(int j = 1; j < numbers.length; j++) { //number of checks to check the larger number

                if(tempArray[j - 1] > tempArray[j]) { //if the number on the left is larger than the number on the right

                    int temp = tempArray[j - 1]; //set a temporary number with the larger number

                    //swap both numbers
                    tempArray[j - 1] = tempArray[j]; //set the left element as the smallest
                    tempArray[j] = temp; //set the right element as the largest
                }
            }
        }

        System.out.println("Finished sorting: " + Arrays.toString(tempArray));
    }

}
