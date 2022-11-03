import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main{
    public static int score      = 0;
    public static int totalQuest = 0;
    
    public static Scanner input = new Scanner(System.in);
    
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
    
    public static void menu(){
        System.out.println("   ____        _     __  __       _             \n  / __ \\      (_)   |  \\/  |     | |            \n | |  | |_   _ _ ___| \\  / | __ _| | _____ _ __ \n | |  | | | | | |_  / |\\/| |/ _` | |/ / _ \\ '__|\n | |__| | |_| | |/ /| |  | | (_| |   <  __/ |   \n  \\___\\_\\\\__,_|_/___|_|  |_|\\__,_|_|\\_\\___|_|   ");
        System.out.println(" ===============================================");
        System.out.println(" [#] Menu | Total Question: "+totalQuest);
        System.out.println("  |");
        System.out.println("  | [1] Add    Question  [4] Start Quiz");
        System.out.println("  | [2] Edit   Question  [5] Exit Program");
        System.out.println("  | [3] Delete Question");
        System.out.println("  |");
        System.out.print(" [>] Input Menu: ");
    }
    
	public static void main(String[] args) {
	    // for input
	    int inputMenu = 0;
	    
	    // for question menu
	    int index = 0;
	    String question, a, b, c, d, rightAnswer;
	    String userAnswer;
	    
	    // for catch question object
	    ArrayList<Quest> DB = new ArrayList<Quest>();
	    
	    do{
	        // Call clearConsole function
	        
	        clearConsole();
	        // Call menu function
	        menu();
	        
	        // Input Menu
	        try{
	            inputMenu = input.nextInt();
	            input.nextLine();
	        } catch(Exception e){
	            input.nextLine();
	            continue;
	        }
	        
	        // Exit menu
	        if(inputMenu == 5){
	            System.out.print("\n [$] INFO: Thank You!");
	            pauseProgram();
	            System.exit(0);
	        }
	        
	        switch(inputMenu){
	            case 1:
	                // Question
	                System.out.print("\n [#] Question: ");
	                question = input.nextLine();
	                
	                // Answer a..d
	                System.out.print("  |\n  | [A] Answer: ");
	                a = input.nextLine();
	                System.out.print("  | [B] Answer: ");
	                b = input.nextLine();
	                System.out.print("  | [C] Answer: ");
	                c = input.nextLine();
	                System.out.print("  | [D] Answer: ");
	                d = input.nextLine();
	                
	                // Right Answer
	                System.out.print("  |\n [>] Right Answer: [A..D] ");
	                rightAnswer = input.nextLine();
	                
	                // Add to arraylist
	                DB.add(new Quest(question, a, b, c, d, rightAnswer));
	                
	                // Increment totalQuest
	                totalQuest += 1;
	                
	                System.out.print("\n [!] INFO: Success add question!");
	                pauseProgram();
	                break;
	            case 2:
	                if(totalQuest == 0){
	                    // if totalQuest empty handle
	                    System.out.print("\n [!] ERROR: Question empty!");
	                    pauseProgram();
	                } else{
	                    System.out.print("\n [$] List Question >> Edit Question\n  |");
	                    
	                    for(int i=0; i<totalQuest; i++){
	                        System.out.print("\n  | ["+(i+1)+"] ");
	                        DB.get(i).getQuestion();
	                    }
	                    
	                    try{
	                        System.out.print("\n  |\n [>] Input Index: [1.."+totalQuest+"] ");
	                        index = input.nextInt();
	                        input.nextLine();
	                        
	                        if(index < 1 || index > totalQuest){
	                            break;
	                        }
	                        
	                        // Question
        	                System.out.print("\n [#] Question: ");
        	                question = input.nextLine();
        	                
        	                // Answer a..d
        	                System.out.print("  |\n  | [A] Answer: ");
        	                a = input.nextLine();
        	                System.out.print("  | [B] Answer: ");
        	                b = input.nextLine();
        	                System.out.print("  | [C] Answer: ");
        	                c = input.nextLine();
        	                System.out.print("  | [D] Answer: ");
        	                d = input.nextLine();
        	                
        	                // Right Answer
        	                System.out.print("  |\n [>] Right Answer: [A..D] ");
        	                rightAnswer = input.nextLine();
        	                
        	                // Add to arraylist
        	                DB.set(index-1, new Quest(question, a, b, c, d, rightAnswer));
        	                
        	                System.out.print("\n [!] INFO: Success edit question!");
	                        pauseProgram();
	                    } catch(Exception e){
	                        input.nextLine();
	                        continue;
	                    }
	                }
	                break;
	            case 3:
	                if(totalQuest == 0){
	                    // if totalQuest empty handle
	                    System.out.print("\n [!] ERROR: Question empty!");
	                    pauseProgram();
	                } else{
	                    System.out.print("\n [$] List Question >> Delete Question\n  |");
	                    
	                    for(int i=0; i<totalQuest; i++){
	                        System.out.print("\n  | ["+(i+1)+"] ");
	                        DB.get(i).getQuestion();
	                    }
	                    
	                    try{
	                        System.out.print("\n  |\n [>] Input Index: [1.."+totalQuest+"] ");
	                        index = input.nextInt();
	                        input.nextLine();
	                        
	                        if(index < 1 || index > totalQuest){
	                            break;
	                        }
	                        
	                        DB.remove(index-1);
	                        totalQuest -= 1;
	                        
	                        System.out.print("\n [!] INFO: Success delete question!");
	                        pauseProgram();
	                    } catch(Exception e){
	                        input.nextLine();
	                        continue;
	                    }
	                }
	                break;
	            case 4:
	                if(totalQuest == 0){
	                    // if totalQuest empty handle
	                    System.out.print("\n [!] ERROR: Question empty!");
	                    pauseProgram();
	                } else{
	                    clearConsole();
	                    
	                    System.out.print("\n [#] Quiz Start!!\n");
	                    
	                    for(int i=0; i<totalQuest; i++){
	                        System.out.print("\n ["+(i+1));
	                        DB.get(i).showQuest();
	                        rightAnswer = DB.get(i).getAnswer();

                            System.out.print("  |\n [>] Input Question: [A..D] ");
	                        userAnswer  = input.nextLine();
	                        
	                        if(userAnswer.equals(rightAnswer)){
	                            score += (100/totalQuest);
	                        }
	                    }
	                    
	                    if(totalQuest % 2 != 0 && totalQuest != 1){
	                        score += 1;
	                    }
	                    
	                    System.out.print("\n [$] Your score: "+score+" ");
	                    pauseProgram();
	                }
	                break;
	        }
	        
	    } while(true);
	}
}