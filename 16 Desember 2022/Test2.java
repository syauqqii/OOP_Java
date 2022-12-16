public class Test2{
    // Constructor
    public Test2(){
        
    }
    
    // Method to print any object from parameter
    public <H>void print(H input){
        System.out.println(input.getClass().getName());
        System.out.println(input);
    }
}
