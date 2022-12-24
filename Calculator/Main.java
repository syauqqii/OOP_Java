// Tambahkan library
import java.util.Scanner;
import java.io.IOException;

public class Main{
	// Buat global variabel bernama "result" dengan tipe data double
	public static double result = 0;

	// Buat function untuk membersihkan console (command line interface)
	// Link Refrensi (Stackoverflow) : https://stackoverflow.com/a/38365871
	public static void clearConsole(){
		try{
			if(System.getProperty("os.name").contains("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else{
				System.out.print("\033\143");
			}
		} catch (IOException | InterruptedException ex) {}
	}

	// Buat function "operation" untuk pengoperasian matematis kalkulator
	public static double operation(int operator, double num){
		switch(operator){
			case 1:
				return result += num;
			case 2:
				return result -= num;
			case 3:
				return result *= num;
			case 4:
				return result /= num;
			case 5:
				return result %= num;
			case 6:
				return 0;
		}
		return 0;
	}
	
	// Buat function "menu" untuk menampilkan menu kalkulator
	public static void menu(){
		System.out.println(" 1. Addition");
		System.out.println(" 2. Subtraction");
		System.out.println(" 3. Multiplication");
		System.out.println(" 4. Division");
		System.out.println(" 5. Modulo");
		System.out.println(" 6. Clear total");
		System.out.println(" 7. Exit");
		System.out.print(" Operator [1...7]: ");
	}

	// Buat function "main" untuk menjalankan logika program
	public static void main(String[] args){
		double number = 0;
		int operator = 0;
		boolean boolOperator = false, boolNumber = false;

		Scanner input = new Scanner(System.in);

		do{
			clearConsole();

			if (boolOperator && boolNumber){
				result = operation(operator, number);
				boolOperator = false;
				boolNumber = false;
			}

			System.out.println("");

			System.out.println(" Calculator");
			System.out.println(" ==================");
			System.out.printf(" Total = %.2f", result);

			System.out.println("");
			System.out.println("");

			if (result == 0){
				try{
					System.out.print(" Input number : ");
					result = input.nextDouble();
				} catch(Exception e){
					input.nextLine();
					continue;
				}
			}

			if(boolOperator){
				menu();
				System.out.printf("%d", operator);
				System.out.println("");

				try{
					System.out.print(" Input number : ");

					try{
						number = input.nextDouble();
					} catch(Exception e){
						boolNumber = false;
						input.nextLine();
						continue;
					}

					boolNumber = true;
				} catch(Exception e){
					boolNumber = false;
					input.nextLine();
					continue;
				}
			} else{
				menu();

				try{
					operator = input.nextInt();

					if(operator < 1 || operator > 7){
						continue;
					}

					if (result > 0 && operator < 6){
						boolOperator = true;
						System.out.print(" Input number : ");

						try{
							number = input.nextDouble();
							boolNumber = true;
						} catch(Exception e){
							boolNumber = false;
							input.nextLine();
							continue;
						}
					}

					boolNumber = true;
				} catch(Exception e){
					boolNumber = false;
					input.nextLine();
					continue;
				}
			}
			
			if(operator == 6){
			    result = 0;
			}

			if(operator == 7){
				System.exit(0);
			}

		} while(true);
	}
}
