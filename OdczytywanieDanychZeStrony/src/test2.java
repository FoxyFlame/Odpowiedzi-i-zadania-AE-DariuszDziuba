import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 
{ 
	static List<String> listOfSentence = new ArrayList<String>();
	static Scanner in = new Scanner(System.in);
	static String url = "https://api.kanye.rest";
	
    public static void main(String[] args) throws IOException, InterruptedException 
    {
    	String command = "start";  	
		nextSentence(command, url);
    }

    public static void nextSentence(String cmd, String URL) throws IOException
    {
    	if(cmd.equals("next") || cmd.equals("start"))
    	{
    		readFromWeb(URL);
    		System.out.println("Write: next -for next sentence, stop -to stop program");
    		cmd = in.next();
    		nextSentence(cmd, URL);
    	}
    	else if(cmd.equals("stop"))
    	{
    		System.out.println("Program is closed");
    	}
    	else
    	{
    		System.out.println("Write correct command: next -for next sentence, stop -to stop program");
    		cmd = in.next();
    		nextSentence(cmd, URL);
    	}
    }
    
    public static void readFromWeb(String webURL) throws IOException 
    {
        URL url = new URL(webURL);
        boolean sentenceAlreadyExist = false;
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {	
            	line = line.substring(9, line.length()-1);
            	
            	if(listOfSentence.size() == 0)
            	{
            		System.out.println(line);
                    AddToUsedSentence(line);
            	}
            	else
            	{
            		for(int i=0; i < listOfSentence.size(); i++)
                	{
                		if(line.equals(listOfSentence.get(i)))
                		{
                			sentenceAlreadyExist = true;
                		}           		
                	}
            		
            		if(sentenceAlreadyExist)
            		{
            			readFromWeb(webURL);
            		}
            		else
            		{
            			System.out.println(line);
                        AddToUsedSentence(line);
            		}
            	}	
            }
        }
        catch (MalformedURLException e) 
        {
            e.printStackTrace();
            throw new MalformedURLException("URL is malformed!!");
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            throw new IOException();
        }

    }
    
    public static void AddToUsedSentence(String sentence)
    {
    	listOfSentence.add(sentence);
    }
}