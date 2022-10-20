import java.util.Scanner;
import java.io.IOException;

public class Assignment_Maker{
	public static void clearConsole(){
		try{
			if(System.getProperty("os.name").contains("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else{
				System.out.print("\033\143");
			}
		} catch (IOException | InterruptedException ex) {}
	}

	public static void pressEnterKeyToContinue(){ 
        System.out.print(" # Press Enter key to continue...");
        Scanner s = new Scanner(System.in);
        s.nextLine();
	}

	public static void menu(){
		System.out.println("\n # Question Maker\n");
		System.out.println("   > 1. Add Question    ");
		System.out.println("   > 2. Edit Questino   (under development)");
		System.out.println("   > 3. Delete Question (under development)");
		System.out.println("   > 4. Show Question   ");
		System.out.println("   > 5. Exit            ");
		System.out.print("\n # Input Menu: ");
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int baris = 5;
		int kolom = 3;

		String[][] Soal = new String[baris][kolom];

		int input_menu = 0;
		int temp = 0, tmp = 0;
		int jumlah_soal = 0;

		do{
			tmp = 0;
			jumlah_soal = 0;

			clearConsole();
			menu();

			try{
				input_menu = input.nextInt();
				System.out.println("");
			} catch(Exception e){
				input.nextLine();
				continue;
			}

			switch(input_menu){
				case 1:
					if(temp == baris-1){
						// Tampilkan hapus soal / edit
						// ini udh penuh
						break;
					} else if(temp == 0){
						System.out.print("   > How many question? (1-"+baris+") ");

						try{
							jumlah_soal = input.nextInt();
							input.nextLine();

							if(jumlah_soal > baris || jumlah_soal < 1){
								break;
							}
						} catch(Exception e){
							input.nextLine();
							continue;
						}

						for(int i=0; i<jumlah_soal; i++){
							System.out.println("\n # Input Question Number-"+(i+1));
							System.out.println("");

							for(int j=0; j<kolom; j++){
								// Proses input soal
								if(j == 0){
									System.out.print("   > Input Question               : ");
								} else if(j == 1){
									System.out.print("   > Input Multiple Choice Answer : ");
								} else if(j == 2){
									System.out.print("   > Input Correct Ansewer        : ");
								}

								Soal[i][j] = input.nextLine();
							}
							temp += 1;
							System.out.println("");
						}
					} else{
						System.out.print("   > How many question? (1-"+(baris-temp)+") ");

						try{
							jumlah_soal = input.nextInt();
							input.nextLine();

							if(jumlah_soal > baris-temp || jumlah_soal < 1){
								break;
							}
						} catch(Exception e){
							input.nextLine();
							continue;
						}

						tmp = temp;

						for(int i=tmp; i<=jumlah_soal; i++){
							System.out.println("\n # Input Question Number-"+(i+1));
							System.out.println("");

							for(int j=0; j<kolom; j++){
								// Proses input soal
								if(j == 0){
									System.out.print("   > Input Question               : ");
								} else if(j == 1){
									System.out.print("   > Input Multiple Choice Answer : ");
								} else if(j == 2){
									System.out.print("   > Input Correct Ansewer        : ");
								}

								Soal[i][j] = input.nextLine();
							}
							temp += 1;
							System.out.println("");
						}
					}

					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					System.out.println(" # Showing Question\n");

					if(temp == 0){
						System.out.println("   > Empty Question");
					}

					for(int i=0; i<temp; i++){
						for(int j=0; j<kolom-1; j++){
							if(j == 0){
								System.out.println("   "+(i+1)+". "+Soal[i][j]);
							} else if(j == 1){
								System.out.println("      "+Soal[i][j]);
							}
						}
						System.out.println("");
					}

					if(temp == 0){
						System.out.println("");
					}

					pressEnterKeyToContinue();
					break;
				case 5:
					System.exit(0);
					break;	 
			}
		} while(true);
	}
}
