class Quest{
    String question;
    String a, b, c, d;
    String rightAnswer;
    
    Quest(String question, String a, String b, String c, String d, String rightAnswer){
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.rightAnswer = rightAnswer;
    }
    
    void showQuest(){
        System.out.println("] "+question);
        System.out.println("  |  A. "+a);
        System.out.println("  |  B. "+b);
        System.out.println("  |  C. "+c);
        System.out.println("  |  D. "+d);
    }
    
    void getQuestion(){
        System.out.print(question);
    }
    
    String getAnswer(){
        return rightAnswer;
    }
}