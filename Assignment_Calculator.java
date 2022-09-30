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

        public static void start(){
        	double num_1 = 0, num_2 = 0;
		int operator = 0;

		Scanner input = new Scanner(System.in);

		do{
			do{
				if(result == 0){
					clearConsole();

                                	System.out.println("Calculator");
                                	System.out.println("==================");
                                	System.out.printf("Total = %.2f", result);

                                	System.out.println("");
                                	System.out.println("");

                                	System.out.print("Input number : ");
                                	try{
                                		num_1 = input.nextDouble();
                                	} catch(Exception e){
                                		start();
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
                                			start();
                                		}
                                	} catch(Exception e){
                                		start();
                                	}

					if(operator == 7){
                                	        System.exit(0);
                                	}
				} else{
					clearConsole();

                                        System.out.println("Calculator");
                                        System.out.println("==================");
                                        System.out.printf("Total = %.2f", result);

                                        System.out.println("");
                                        System.out.println("");

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
                                			start();
                                		}
                                	} catch(Exception e){
                                		start();
                                	}

                                        if(operator == 7){
                                                System.exit(0);
                                        } else if(operator == 6){
						break;
					}
				}
			} while(operator < 1 || operator > 7);

			if(result == 0){
				switch(operator){
					case 1:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
						result = num_1 + num_2;
						break;
					case 2:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
	                                        result = num_1 - num_2;
	                                        break;
					case 3:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
	                                        result = num_1 * num_2;
	                                        break;
					case 4:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
	                                        result = num_1 / num_2;
	                                        break;
					case 5:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
	                                        result = num_1 % num_2;
	                                        break;
					case 6:
	                                        result = 0;
	                                        break;
					case 7:
						System.exit(0);
						break;
				}
			} else{
				switch(operator){
					case 1:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
						result = result + num_2;
						break;
					case 2:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
	                                        result = result - num_2;
	                                        break;
					case 3:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
	                                        result = result * num_2;
	                                        break;
					case 4:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
	                                        result = result / num_2;
	                                        break;
					case 5:
						System.out.print("Input number : ");
                        			try{
	                                		num_2 = input.nextDouble();
	                                	} catch(Exception e){
	                                		start();
	                                	}
	                                        result = result % num_2;
	                                        break;
					case 6:
	                                        result = 0;
	                                        break;
					case 7:
						System.exit(0);
						break;
				}
			}
		} while(operator != 7);
        }

	public static void main(String[] args){
		start();
	}
}
