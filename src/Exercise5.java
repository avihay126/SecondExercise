public class Exercise5 {
    public static void main(String[] args) {
        int[] array={1,2,3,4,9,4,2,1};
        System.out.println(isArrayUpAndDown(array));
    }
    public static int isArrayUpAndDown(int[]array){
        int biggestNumber=theSummit(array);
        int i;
        if (array[0]==biggestNumber||array[array.length-1]==biggestNumber){
            return -1;
        }else {
            for (i = 0; array[i] != biggestNumber; i++) {
                if (array[i] >= array[i + 1]) {
                    return -1;
                }
            }
            for (int j = i; j < array.length - 1; j++) {
                if (array[j] <= array[j + 1]) {
                    return -1;
                }
            }
        }
        return biggestNumber;
    }
    public static int theSummit(int[] array) {
        int biggestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (biggestNumber < array[i]) {
                biggestNumber = array[i];
            }
        }
        return biggestNumber;
    }
}
