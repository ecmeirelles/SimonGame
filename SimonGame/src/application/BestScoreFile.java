package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BestScoreFile {
	
	public static void main(String[] args) {
		File arquivo = new File("bestScore.txt");
		try( FileWriter fw = new FileWriter( arquivo ) ){
		  BufferedWriter bw = new BufferedWriter(fw);             
		  bw.write("Test");
		  bw.newLine();
		  bw.flush();  
		}catch(IOException ex){
		  ex.printStackTrace();
		}
		 
		try( FileReader fr = new FileReader(arquivo)){
		  BufferedReader br = new BufferedReader(fr);
		  String content;
		  while( ( content = br.readLine() ) != null){
		    System.out.println( content );
		  }
		}catch(IOException ex){
		  ex.printStackTrace();
		}
	}
}
