import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class Assignment_Quiz_Maker{
	// private variable
	private static int maxQuestion = 10;
	private static int column = 8;

	// public variable
	public static Scanner input = new Scanner(System.in);
	public static float score = 0.0f;
	public static int totalQuestion = 0;
	public static int indexInput = 0;
	public static String[][] question = new String[maxQuestion][column];
	/*
		question[0][0] = soal
		question[0][1] = a
		question[0][2] = b
		question[0][3] = c
		question[0][4] = d
		question[0][5] = jawaban benar
		question[0][6] = input jawaban user

		8 kolom - 1 = 7 -> 0,1,2,3,4,5,6
	*/

    // Bersihkan console cmd / terminal
	public static void clearConsole(){
		try{
			if(System.getProperty("os.name").contains("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else{
				System.out.print("\033\143");
			}
		} catch (IOException | InterruptedException ex) {}
	}
	
	// Untuk memberikan efek pause (press enter to continue)
	public static void pauseProgram(){ 
        System.out.print("[ENTER]");
        
        input.nextLine();
	} 
	
	// Menu program
	public static void menuCLI(){
	    System.out.println("   ____        _     __  __       _\n  / __ \\      (_)   |  \\/  |     | |\n | |  | |_   _ _ ___| \\  / | __ _| | _____ _ __\n | |  | | | | | |_  / |\\/| |/ _` | |/ / _ \\ '__|\n | |__| | |_| | |/ /| |  | | (_| |   <  __/ |\n  \\___\\_\\\\__,_|_/___|_|  |_|\\__,_|_|\\_\\___|_|");
		System.out.println("\n [#] Menu Program | Total Question: "+totalQuestion+" | Max Question: "+maxQuestion);
		System.out.println("  |");
		System.out.println("  |  [1] Add Question     [4] Start Quiz");
		System.out.println("  |  [2] Delete Question  [5] Exit Program");
		System.out.println("  |  [3] Edit Question");
		System.out.println("  |");
		System.out.print(" [?] Input menu: ");
	}

	// Fungsi menambahkan soal untuk quiz
	public static void addQuestion(){
		if(totalQuestion != 10){
			System.out.print("\n ["+(totalQuestion+1)+"] Input Question: ");
			question[totalQuestion][0] = input.nextLine();

			System.out.print("  |  \n  |  > Input Answer A: ");
			question[totalQuestion][1] = input.nextLine();

			System.out.print("  |  > Input Answer B: ");
			question[totalQuestion][2] = input.nextLine();

			System.out.print("  |  > Input Answer C: ");
			question[totalQuestion][3] = input.nextLine();

			System.out.print("  |  > Input Answer D: ");
			question[totalQuestion][4] = input.nextLine();

			System.out.print("  |  \n  +-[?] Input Right Answer: ");
			question[totalQuestion][5] = input.nextLine();

			System.out.print("\n    [!] Success Add Question! ");
			totalQuestion += 1;
		} else{
			System.out.print("\n [!] Question Full! ");
		}

		pauseProgram();
	}

	// Fungsi hapus soal quiz
	public static void deleteQuestion(){
		if(totalQuestion == 0){
			System.out.print("\n [!] Empty Question! ");
		} else{
			System.out.println("\n [>] List Question: ");

			for(int i=0; i<totalQuestion; i++){
				System.out.println("     "+(i+1)+"). "+question[i][0]);
			}

			System.out.print("\n [>] Input Number Question: [1.."+totalQuestion+"] ");
			indexInput = input.nextInt();

			for(int i=0; i<column-1; i++){
				question[indexInput][i] = "";
			}

			System.out.print("\n [!] Success Delete Question! ");
			totalQuestion -= 1;
		}

		pauseProgram();
	}

	// Fungsi edit soal quiz
	public static void editQuestion(){
		if(totalQuestion == 0){
			System.out.print("\n [!] Empty Question! ");
		} else{
			System.out.println("\n [>] List Question: ");

			for(int i=0; i<totalQuestion; i++){
				System.out.println("     "+(i+1)+"). "+question[i][0]);
			}

			System.out.print("\n [>] Input Number Question: [1.."+totalQuestion+"] ");
			indexInput = input.nextInt();

			if(indexInput < 1 || indexInput > totalQuestion){
				return;
			}

			input.nextLine();

			System.out.print("\n ["+indexInput+"] Input Question: ");
			question[indexInput-1][0] = input.nextLine();

			System.out.print("  |  \n  |  > Input Answer A: ");
			question[indexInput-1][1] = input.nextLine();

			System.out.print("  |  > Input Answer B: ");
			question[indexInput-1][2] = input.nextLine();

			System.out.print("  |  > Input Answer C: ");
			question[indexInput-1][3] = input.nextLine();

			System.out.print("  |  > Input Answer D: ");
			question[indexInput-1][4] = input.nextLine();

			System.out.print("  |  \n  +-[?] Input Right Answer: ");
			question[indexInput-1][5] = input.nextLine();

			System.out.print("\n    [!] Success Edit Question! ");
		}

		pauseProgram();
	}

	// Fungsi memulai quiz
	public static void startQuiz(){
		if(totalQuestion == 0){
			System.out.print("\n [!] Empty Question! ");
		} else{
			clearConsole();
			System.out.println("\n [#] Quiz Start!");

			for(int i=0; i<totalQuestion; i++){
				for(int j=0; j<column-1; j++){
					if(j == 0){
						System.out.println("\n  "+(i+1)+"). "+question[i][j]);
					} else if(j == 1){
						System.out.println("\n    A. "+question[i][j]);
					} else if(j == 2){
						System.out.println("    B. "+question[i][j]);
					} else if(j == 3){
						System.out.println("    C. "+question[i][j]);
					} else if(j == 4){
						System.out.println("    D. "+question[i][j]);
					} else if(j == 5){
						System.out.print("\n  > Input Answer: [A..D] ");
						question[i][j+1] = input.nextLine();

						Object[] arr1 = { question[i][j].toUpperCase() };
						Object[] arr2 = { question[i][j+1].toUpperCase() };

						if(Arrays.equals(arr1, arr2)){
							score += (100/totalQuestion);
						}
					}
				}
			}

			if(totalQuestion % 2 == 1 && totalQuestion != 1){
				score += 1;
			}

			System.out.print("\n [!] Score: "+score+" | Back to menu ");
		}
		pauseProgram();
	}
	
	// Main program
	public static void main(String[] args){
		int input_menu  = 0;

	    do{
	        do{
	        	indexInput = 0;
	        	score = 0;

	            clearConsole();
	            menuCLI();
	            
	            try{
    				input_menu = input.nextInt();
    				input.nextLine();
    			} catch(Exception e){
    				input.nextLine();
    				continue;
    			}
	        } while(input_menu < 1 || input_menu > 5);
	        
	        if(input_menu == 5){
	            System.exit(0);
	        }
	        
	        switch(input_menu){
	            case 1:
	            	addQuestion();
	            	break;
	            case 2:
	            	deleteQuestion();
	            	break;
	            case 3:
	            	editQuestion();
	            	break;
	            case 4:
	            	startQuiz();
	            	break;
	        }
	    } while(input_menu != 5);
	}
}
