import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        getPositionFromUser();
    }
    public static void printBoard(char[] board){
        for (int i=0; i<board.length;i++){
            System.out.print(board[i]+" ");
            if (i==2||i==5){
                System.out.println("");
            }
        }
        System.out.println("");
    }
    public static boolean isAvailable(char[]board,int boardIndex){
        boolean isFree= false;
        if (board[boardIndex]!='x'&&board[boardIndex]!='o'){
            isFree =true;
        }
        return isFree;
    }
    public static void getPositionFromUser(){
        Scanner scanner =new Scanner(System.in);
        char []board ={'1','2','3','4','5','6','7','8','9'};
        printBoard(board);
        int userChoice;
        int indexInBoard=0;
        int counter=0;
        boolean isWinner=false;
        boolean isFree=false;
        char playerIcon ='x';
        while (!isWinner&&counter<9){
            counter++;
            do {
                System.out.println("player "+playerIcon+" Enter the selected location:(1-9)");
                userChoice=scanner.nextInt();
                if (userChoice>=1&&userChoice<=9) {
                    indexInBoard = userChoice - 1;
                    isFree = isAvailable(board, indexInBoard);
                    if (!isFree){
                        System.out.println("The location isn't available:");
                    }

                }else {
                    System.out.println("Your choice is out of range");
                }
            }while (!isFree);
            isWinner=placeSymbolOnBoard(board,indexInBoard,playerIcon);
            if (playerIcon=='x'){
                playerIcon='o';
            }else {
                playerIcon='x';
            }
        }
        if (counter==9&&!isWinner){
            System.out.println("The game ended in a draw");
        }
    }
    public static char checkWinner(char[]board){
        char winner='-';
        for (int i=0;i<3;i++){
            if (board[i]==board[i+3]&&board[i]==board[i+6]){
                winner=board[i];
                return winner;
            }
        }
        for (int i =0;i<board.length;i+=3){
            if (board[i]==board[i+1]&&board[i]==board[i+2]){
                winner=board[i];
                return winner;
            }
        }
        if ((board[4]==board[0]&&board[4]==board[8])||(board[4]==board[2]&&board[4]==board[6])){
            winner=board[4];
            return winner;
        }
        return winner;
    }
    public static boolean placeSymbolOnBoard(char[]board, int indexInBoard,char playerIcon){
        boolean isWinner=false;
        board[indexInBoard]=playerIcon;
        printBoard(board);
        char winner=checkWinner(board);
        if (winner=='x'||winner=='o'){
            System.out.println("The winner is: "+ winner);
            isWinner=true;
        }
        return isWinner;
    }
}
