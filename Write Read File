import java.util.Scanner;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;

class Makanan{
    String nama;
    int harga;
    
    public Makanan(String nama, int harga){
        this.nama  = nama;
        this.harga = harga;
    }
    
    void setNama(String nama){
        this.nama = nama;
    }
    
    void setHarga(int harga){
        this.harga = harga;
    }
    
    String getNama(){
        return this.nama;
    }
    
    int getHarga(){
        return this.harga;
    }
}

public class Main{
    public static Scanner input = new Scanner(System.in);
    
	public static void main(String[] args) {
	    ArrayList<Makanan> list = new ArrayList<Makanan>();
	    
	    String[] menu = {"Mie Ayam 7500", "Nasi Goreng 10000", "Rawon 15000"};
	    
	    // Write file hehe 
	    
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));
	        
	        for(String lists : menu){
	            writer.write(lists + "\n");
	        }
	        
	        writer.close();
	    } catch(IOException e) {
	        e.printStackTrace();
	    }
	    
	    // Read file hehe
	    
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("Output.txt"));
	        String line;
	        while((line = reader.readLine()) != null){
	            list.add(new Makanan(line.substring(0, line.lastIndexOf(' ')), Integer.parseInt(line.substring(line.lastIndexOf(' ')+1))));
	        }
	        reader.close();
	    } catch(IOException e) {
	        e.printStackTrace();
	    }
	    
	    // Output into console hehe
	    for(int i=0; i<list.size(); i++){
	        System.out.println(list.get(i).getNama());
	    }
	}
}
