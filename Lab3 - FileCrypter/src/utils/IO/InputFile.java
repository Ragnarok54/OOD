package utils.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputFile {
	
    public String readLine(String filePath, int line) {
        FileInputStream inputStream = null;
        String string = "";
        try{
            inputStream = new FileInputStream(filePath);
            Scanner fileScanner = new Scanner(inputStream);
            for(int i = 1; i <= line; i++)
            	string = fileScanner.nextLine();    
            fileScanner.close();
        }
        catch (FileNotFoundException e){
        	
            System.out.println("Error while opening file " + e.getMessage());
            e.printStackTrace();
        }
        catch (NoSuchElementException e){
        	
            System.out.println("Error while processing file " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
        	
            System.out.println("Error while processing file " + e.getMessage());
            e.printStackTrace();
        }
        
        if(inputStream != null) {
            try{
                inputStream.close();
            }
            catch(IOException e)
            {
                System.out.println("File is not open " + e.getMessage());
            }
        }
        
        return string;
    }
    
}
