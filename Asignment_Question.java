import java.util.Scanner;
import java.io.IOException;

public class Asignment_Question{
	public static void clearConsole(){
		try{
			if(System.getProperty("os.name").contains("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else{
				System.out.print("\033\143");
			}
		} catch (IOException | InterruptedException ex) {}
	}

	public static void main(String[] args){
		clearConsole();

		Scanner input = new Scanner(System.in);

		int baris = 5, kolom = 4;
		float nilai = 0;

		String[][] Soal = new String[baris][kolom];

		Soal[0][0] = " 1). 3 + 2 = ";
		Soal[0][1] = "     A. 5     B. 2     C. 7     D. 0";
		Soal[0][2] = "A";

		Soal[1][0] = " 2). 7 - 2 = ";
		Soal[1][1] = "     A. 1     B. 4     C. 2     D. 5";
		Soal[1][2] = "D";

		Soal[2][0] = " 3). 1 x 5 = ";
		Soal[2][1] = "     A. 3     B. 5     C. 1     D. 9";
		Soal[2][2] = "B";

		Soal[3][0] = " 4). 5 : 1 = ";
		Soal[3][1] = "     A. 8     B. 7     C. 5     D. 1";
		Soal[3][2] = "C";

		Soal[4][0] = " 5). 9 - 4 = ";
		Soal[4][1] = "     A. 3     B. 9     C. 7     D. 5";
		Soal[4][2] = "D";

		for(int i = 0; i <= baris-1; i++){
			System.out.println("\n Kerjakan soal dibawah ini!\n");

			for(int j = 0; j <= kolom-3; j++){
				System.out.println(Soal[i][j]);
			}
			System.out.print("\n  > Jawaban anda: (A-D) ");
			Soal[i][3] = input.nextLine();

			System.out.print("\n");

			if(Soal[i][2].equals(Soal[i][3].toUpperCase())){
					nilai += (100/baris);
			}

			clearConsole();
		}

		System.out.println("\n Nilai anda: " + nilai + "\n");
	}
}
