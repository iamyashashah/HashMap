import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

public class HashMaps {
	static Scanner sc=new Scanner(System.in);
	static int number;
	static String value;
	static HashMap<Integer, String> myMap = new HashMap<Integer, String>();
	static File file = new File("hashMapfile.txt");
	static int i = 0;

	public static void main(String[] args) {

		Read();
		System.out.println("Enter how many value you want to store :");
		int number_value= sc.nextInt();
		while(i < number_value)
		{
		System.out.println("Enter a key :");
		number = sc.nextInt();
	
		if(myMap.containsKey(number))
		{
			System.out.println(myMap.get(number));
		}
		else
		{
			System.out.println("Value not present");
			System.out.println("enter a value for the key:");
			value=sc.next(); //scanning the value
			myMap.put(number, value); //Mapping the value
			//System.out.println(myMap.get(number));//Testing purpose
		}
	i++;
		Write();
		}

	}
	public static void Read() 
	{
		try
		{
			Scanner input =new Scanner(file);
			while(input.hasNextLine())
			{
				String line =input.nextLine();
				String []numval=line.split(" ");
				int newnumber=Integer.parseInt(numval[0]);
				myMap.put(newnumber, numval[1]);
			}
			input.close();

		}
		catch(IOException e)
		{
			e.getMessage().toString();
		}
	}

	
	public static void Write()
	{
		try{

			file.createNewFile();
			FileWriter writer = new FileWriter(file); 
			for(int n:myMap.keySet())
			{
				writer.write(n +" "+ myMap.get(n)+"\n"); 
			}
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			e.getMessage().toString();
		}
	}
	


}