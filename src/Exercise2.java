import java.util.Scanner;

public class Exercise2 {
    public static final int ARRAY_SIZE =10;

    public static void main(String[] args) {
        int []array= new int[ARRAY_SIZE];
        printBiggerThanAverage(array);
    }
    public static void printBiggerThanAverage(int[]array){
        Scanner scanner=new Scanner(System.in);
        int sum =0;
        double average;
        for (int i=0; i<array.length;i++){
            System.out.println("Enter a number in index "+i);
            array[i]=scanner.nextInt();
            sum= sum+array[i];
        }
        average = sum/array.length;
        for (int i=0;i<array.length;i++){
            if (array[i]>average){
                        System.out.print(array[i] + " ");
            }
        }
    }
}
