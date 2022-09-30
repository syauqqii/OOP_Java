import java.util.Scanner;
import java.io.IOException;


public class Assignment_Calculator{
	public static double result = 0;

	public static void clearConsole(){
		try{
			if(System.getProperty("os.name").contains("Windows")){
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else{
					System.out.print("\033\143");
			}
		} catch (IOException | InterruptedException ex) {}
    }

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

    public static void start(){
        double num_1 = 0, number = 0;
		int operator = 0;
		boolean success = false;

		Scanner input = new Scanner(System.in);
		do{
			clearConsole();
			if (success){
				result = operation(operator, number);
			}
			System.out.println("Calculator");
			System.out.println("==================");
			System.out.printf("Total = %.2f", result);

			System.out.println("");
			System.out.println("");

			
			if (result == 0){
				try{
					System.out.print("Input number : ");
					result = input.nextDouble();
				} catch(Exception e){
					input.nextLine();
					continue;
				}
			}
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Modulo");
			System.out.println("6. Clear Total");
			System.out.println("7. Exit");
			System.out.print("Operator [1...7]: ");
			try{
				operator = input.nextInt();
				if(operator < 1 || operator > 7){
					continue;
				}
				if (result > 0 && operator < 6){
					System.out.print("Input number : ");
					try{
						number = input.nextDouble();
						success = true;
					} catch(Exception e){
						success = false;
						input.nextLine();
						continue;
					}
				}
				success = true;
			} catch(Exception e){
				success = false;
				input.nextLine();
				continue;
			}

			if(operator == 7){
				System.exit(0);
			}
		} while(true);

	}
	
	public static void main(String[] args){
		start();
	}
}
