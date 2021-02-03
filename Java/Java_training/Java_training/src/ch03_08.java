import java.util.Scanner;
public class ch03_08 {
 
	public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int x = 0;
        int y = 0;
 
        for (int i = 0; i < 8; i++) {
            x = (int) Math.round(Math.random() * 3);
            y = (int) Math.round(Math.random() * 3);
 
            while (arr[x][y] != 0) {
                x = (int) Math.round(Math.random() * 3);
                y = (int) Math.round(Math.random() * 3);
            }
            arr[x][y] = (int) Math.round(Math.random() * 9 + 1);
        }
 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
 
    }
}
