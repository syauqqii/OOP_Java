public class Test<I, S, D>{
    I obj; // Integer
    S obj2; // String
    D obj3; // Double
    
    // constructor
    public Test(I obj, S obj2, D obj3){
        this.obj = obj;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }
    
    // method get object value
    public I getObj(){
        return this.obj;
    }
    
    public S getObj2(){
        return this.obj2;
    }
    
    public D getObj3(){
        return this.obj3;
    }
}
