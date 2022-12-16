/*
 * Mengambil function cetak dari abstract class
 * File class : (Test3.java)
 *  -> yang diambil function cetak()
 */
public class PrintString<O> extends Test3{
    O obj;
    
    public PrintString(O obj){
        this.obj = obj;
    }
    
    @Override
    <O> O cetak(){
        return (O) obj;
    }
}
