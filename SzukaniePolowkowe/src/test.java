import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class test {
    public static void main(String args[]) {
      Scanner in = new Scanner(System.in);
    
      System.out.println("Podaj iloœæ komórek tablicy: "); 
      int maxTab = in.nextInt();
      
      System.out.println("Podaj max zakres liczb do wpisania do tablicy (0-max): ");
      int maxValue = in.nextInt();
      
      System.out.println("Podaj element do wyszukania z zakresu 0-" + maxValue + ": ");
      int numberToFind = in.nextInt();
        
      Random rand = new Random();
      int[] numbersTab = new int[maxTab];
      
      for(int i=0; i<maxTab; i++)
      {
          numbersTab[i] = rand.nextInt(maxValue+1); //0-maxValue
      }
      
      Arrays.sort(numbersTab);     
      reverse(numbersTab);
      
      if(search(numbersTab, numberToFind))
      {
    	  System.out.println("Szukana liczba zosta³a znaleziona");
      }
      else
      {
    	  System.out.println("Szukana liczba nie zosta³a znaleziona");
      }
    }
    
    public static void reverse(int[] array) 
    { 
        int n = array.length; 

        for (int i = 0; i < n / 2; i++) 
        { 
            int temp = array[i]; 
            array[i] = array[n - i - 1]; 
            array[n - i - 1] = temp; 
        } 
    }
    
    private static boolean search(int[] numbers, int x)
    {
        int l=0, p=numbers.length-1, s=0;
        
        while(l<=p)
        {
        	s = (l+p) / 2;
        	System.out.println(numbers[s]);
        	if(numbers[s] == x)
        	{
        		return true;
        	}
        	else if(numbers[s] > x)
        	{
        		l = s + 1;
        	}
        	else
        	{
        		p = s - 1;
        	}
        }
        return false;       
    }

}