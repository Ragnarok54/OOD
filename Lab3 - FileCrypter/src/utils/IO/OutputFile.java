package utils.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class OutputFile {
	
	public void write(String filePath, String s, boolean append ) {
	       FileOutputStream outputStream = null;

	        try
	        {	
	        	if(append == true)
	        		outputStream = new FileOutputStream(filePath, true);
	        	else
	        		outputStream = new FileOutputStream(filePath);

	            PrintWriter writer = new PrintWriter(outputStream);
	            
	            writer.print(s);
	            writer.flush();
	            writer.close();
	        }
	        catch (FileNotFoundException e){
	        	
	            System.out.println("Error while opening the file " + e.getMessage());
	        }
	        catch (NoSuchElementException e){
	        	
	            System.out.println("Error while processing the file " + e.getMessage());
	        }
	        catch(Exception e){
	        	
	            System.out.println("Error while processing the file " + e.getMessage());
	        }
	        
	        if(outputStream != null) {
	            try
	            {
	                outputStream.close();
	            }
	            catch(IOException e)
	            {
	                System.out.println("File is not open " + e.getMessage());
	            }
	        }
	    }
}
