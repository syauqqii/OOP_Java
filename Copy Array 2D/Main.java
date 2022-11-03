public class Main{
    public static void main(String[] args){
        String[][] dataMahasiswa = {{"Syauqi", "2502004405"}, {"Bot", "2502003307"}};
        String[][] backUP = new String[dataMahasiswa.length][];
        
        System.arraycopy(dataMahasiswa, 0, backUP, 0, dataMahasiswa.length);
        
        for(int i=0; i<dataMahasiswa.length; i++){
            for(int j=0; j<dataMahasiswa[i].length; j++){
                System.out.print(backUP[i][j]+" ");
            }
            System.out.println(" ");
        }
        
    }
}
