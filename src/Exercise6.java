public class Exercise6 {
    public static final int MIN_DOUBLE_DIGIT=10,MAX_DOUBLE_DIGIT=99;
    public static void main(String[] args) {
        int[] arr1 = {30, 90, 10, 50, 50};
        int[] arr2 = {30, 70, 30, 90, 30};
        int[] cuttingArray;
        if (isDoubleDigit(arr1)&&isDoubleDigit(arr2)) {
            cuttingArray = cuttingArray(arr1, arr2);
            for (int i = 0; i < cuttingArray.length; i++) {
                System.out.print(cuttingArray[i] + " ");
            }
        }
        System.out.println(areStrangers(arr1, arr2));
    }
    public static boolean isDoubleDigit(int[]arr){
        boolean answer=false;
        for (int i = 0;i<arr.length;i++){
            if (arr[i]<MIN_DOUBLE_DIGIT||arr[i]>MAX_DOUBLE_DIGIT){
                break;
            }else if (i==arr.length-1){
                answer=true;
            }
        }
        return answer;
    }

    public static int[] cuttingArray(int[] arr1, int[] arr2) {
        int secondArrayHelpsLength = 0;
        int[] firstArrayHelps = new int[arr1.length];
        int indexFirstArrayHelps = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (indexFirstArrayHelps == arr1.length) {
                break;
            }
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    secondArrayHelpsLength++;
                    firstArrayHelps[indexFirstArrayHelps] = arr1[i];
                    indexFirstArrayHelps++;
                    break;
                }
            }
        }
        int[] secondArrayHelps = new int[secondArrayHelpsLength];
        int cuttingArrayLength = secondArrayHelpsLength;
        int indexSecondArrayHelps = 0;
        for (int i = 0; i < indexFirstArrayHelps; i++) {
            if (i == indexFirstArrayHelps - 1) {
                secondArrayHelps[indexSecondArrayHelps] = firstArrayHelps[i];
            }
            for (int j = i + 1; j < indexFirstArrayHelps; j++) {
                if (firstArrayHelps[i] == firstArrayHelps[j]) {
                    cuttingArrayLength--;
                    break;
                }
                if (j == indexFirstArrayHelps - 1) {
                    secondArrayHelps[indexSecondArrayHelps] = firstArrayHelps[i];
                    indexSecondArrayHelps++;
                }
            }
        }
        int[] cuttingArray = new int[cuttingArrayLength];
        for (int i = 0; i < cuttingArrayLength; i++) {
            cuttingArray[i] = secondArrayHelps[i];
        }
        return cuttingArray;
    }

    public static boolean areStrangers(int[] arr1, int[] arr2) {
        boolean areStrangers = false;
        int[] cuttingArray = cuttingArray(arr1, arr2);
        if (cuttingArray.length == 0) {
            areStrangers = true;
        }
        return areStrangers;
    }
}
