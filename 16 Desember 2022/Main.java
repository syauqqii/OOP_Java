public class Main{
    public static void main(String[] args){
        // ========================================================================================
        // File Class : (Test.java)
        // Versi get tipe data melalui constructor class
        Test <Integer, String, Double>t1 = new Test(100, "Hello World", 2.4);
        
        int a = t1.getObj();
        String b = t1.getObj2();
        Double c = t1.getObj3();
        
        System.out.printf("%d, %s, %.2f\n\n", a, b, c);
        
        // ========================================================================================
        // File Class : (Test2.java)
        // Versi print dinamis tipe data dengan cara input di parameter function print
        Test2 t2 = new Test2();
        t2.print("Hello World");
        t2.print(100);
        
        // ========================================================================================
        // File Class : (PrintString.java)
        // Versi print string
        PrintString <String>p1 = new PrintString("Hello World");
        String d = p1.cetak();
        System.out.printf("\n%s", d);
        
        // ========================================================================================
        // File Class : (PrintDouble.java)
        // Versi print double
        PrintDouble <String>p2 = new PrintDouble(2.4);
        Double e = p2.cetak();
        System.out.printf("\n%.2f", e);
    }
}
