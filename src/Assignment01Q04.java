import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] OneStepShift(int[] array, int step){
        int length = array.length;
        if (length < 1) 
            return array;
        if(step == 1){
            int last = array[length - 1];
            for(int i = length - 1; i > 0; i--){
                array[i] = array[i - 1];
            }
            array[0] = last;
        } else if(step == -1){
            int first = array[0];
            for(int i = 0; i < length - 1; i++){
                array[i] = array[i + 1];
            }
            array[length - 1] = first;
        }
        return array;
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction){
        if(array.length == 0 || (direction != 'L' && direction != 'R')){
            return array;
        }
        move = move % array.length;
        if(move < 0) {
            return shiftArrayCyclic(array, -move, direction == 'L' ? 'R' : 'L');
        }
        int step = (direction == 'L') ? -1 : 1;
        for(int i = 0; i < move; i++) {
            OneStepShift(array, step);
        }
            return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}