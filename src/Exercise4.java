public class Exercise4 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,-9,-5,-9,4,3,1,-8,4,2,-8,3};
        int[] newArray = arrayWithoutDuplication(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
    public static int[] arrayWithoutDuplication(int[] array) {
        int arrayWithoutDuplicationLength = array.length;
        int[] preNewArray =new int[array.length];
        int indexPreArray=0;
        for (int i = 0; i < array.length; i++) {
            if (i==array.length-1){
                preNewArray[indexPreArray]=array[i];
            }
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    arrayWithoutDuplicationLength--;
                    break;
                }
                if (j==array.length-1){
                    preNewArray[indexPreArray]=array[i];
                    indexPreArray++;
                }
            }
        }
        int[] arrayWithoutDuplication = new int[arrayWithoutDuplicationLength];
        for (int i = 0; i < arrayWithoutDuplicationLength; i++) {
            arrayWithoutDuplication[i]=preNewArray[i];
        }
        return arrayWithoutDuplication;
    }
}