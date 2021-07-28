import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        System.out.println("X is player 1.\nO is player 2.");
        String[] n = new String[9];
        Scanner sc = new Scanner(System.in);
        String player = " X";
        int cnt = 1;
        for(int i = 0; i < 9; i++)
            n[i] = "[" + String.valueOf(i + 1) + "]";
        System.out.println("Here is the table:");
        print(n);
        while(true){
            System.out.println("Enter player" + player + " your choice of position:");
            int pos = sc.nextInt();
            pos--;
            //to check whether the entered position is already occupied
            if(n[pos].equals(" X") || n[pos].equals(" O") || pos > 8) {
                System.out.println("That position is occupied or out of reach. Enter another.");
                continue;
            }
            n[pos] = player;
            print(n); //Displays the table
            //Checks whether the player has won
            if(winCheck(pos, ((player.equals(" X"))?'X':'O'), n )){
                System.out.println("The winner is " + player);
                break;
            }
            //Tie check
            if(cnt == 9) {
                System.out.println("TIE");
                break;
            }
            player = (player.equals(" X"))?" O":" X";//Switches the player for the next round
            cnt++;//For keeping the count of the rounds
        }

    }
    static boolean winCheck(int pos, char ch, String s[]){
        boolean flag = false;
        char c[] = new char[9];
        for(int i = 0; i < 9; i++) {
            if (s[i].charAt(0) == '[')
                c[i] = (char)(i + 49);
            else
                c[i] = s[i].charAt(1);
        }
        switch(pos)
        {
            case 0:
                if (ch == c[4]&& ch == c[8])
                    flag = true;
                else if (ch == c[1]&& ch == c[2])
                    flag = true;
                else if (ch == c[3]&& ch == c[6])
                    flag = true;
                break;

            case 1:
                if (ch == c[0]&& ch == c[2])
                    flag = true;
                if (ch == c[4]&& ch == c[7])
                    flag = true;
                break;

            case 2:
                if (ch == c[0]&& ch == c[1])
                    flag = true;
                if (ch == c[4]&& ch == c[6])
                    flag = true;
                if (ch == c[5]&& ch == c[8])
                    flag = true;
                break;

            case 3:
                if (ch == c[0]&& ch == c[6])
                    flag = true;
                if (ch == c[4]&& ch == c[5])
                    flag = true;
                break;

            case 4:
                if (ch == c[3]&& ch == c[5])
                    flag = true;
                if (ch == c[1]&& ch == c[7])
                    flag = true;
                if (ch == c[0]&& ch == c[8])
                    flag = true;
                if (ch == c[2]&& ch == c[6])
                    flag = true;
                break;

            case 5:
                if (ch == c[2]&& ch == c[8])
                    flag = true;
                if (ch == c[3]&& ch == c[4])
                    flag = true;
                break;

            case 6:
                if (ch == c[0]&& ch == c[3])
                    flag = true;
                if (ch == c[4]&& ch == c[2])
                    flag = true;
                if (ch == c[7]&& ch == c[8])
                    flag = true;
                break;

            case 7:
                if (ch == c[6]&& ch == c[8])
                    flag = true;
                if (ch == c[1]&& ch == c[4])
                    flag = true;
                break;

            case 8:
                if (ch == c[0]&& ch == c[4])
                    flag = true;
                if (ch == c[2]&& ch == c[5])
                    flag = true;
                if (ch == c[6]&& ch == c[7])
                    flag = true;
                break;
        }
        return flag;
    }

    static void print(String n[])
    {
        System.out.println("\t" + n[0] + "\t │\t" + n[1] + "\t │\t" + n[2]); // + "\n");
        System.out.println("\t───\t ┼\t───\t ┼\t───");
        System.out.println("\t" + n[3] + "\t │\t" + n[4] + "\t │\t" + n[5]); // + "\n");
        System.out.println("\t───\t ┼\t───\t ┼\t───");
        System.out.println("\t" + n[6] + "\t │\t" + n[7] + "\t │\t" + n[8]); // + "\n");
    }
}
