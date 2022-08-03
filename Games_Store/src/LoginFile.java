import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginFile 
{

	public int addAccount(String name ,String password)throws FileNotFoundException
	{

	try (FileWriter f = new FileWriter("Login.txt", true);
	
	BufferedWriter b = new BufferedWriter(f);
	PrintWriter p = new PrintWriter(b);) 
	
	{ 
		Scanner scanner = new Scanner(new File("Login.txt"));
		 ArrayList<String> st = new ArrayList<String>();
		 String sub_data[];
		int j = 0;
		while (scanner.hasNextLine()) {
			st.add(scanner.nextLine());
			sub_data = st.get(j).split("-");
			if(sub_data[0].equals(name))
				return 0;
			j++;
		}
		
		p.println(name+"-"+password+"-0"+"-0"+"-0"+"-0");
		return 1;
		} catch (IOException i) {
			i.printStackTrace(); 
		}
			return 0;
	}
		
	public String[] check(String s) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("Login.txt"));
		 ArrayList<String> st = new ArrayList<String>();
		 String sub_data[] = null;
		 int j=0;
		while (scanner.hasNextLine()) {
			st.add(scanner.nextLine());
			sub_data = st.get(j).split("-");
			if((sub_data[0]+"-"+sub_data[1]).equals(s)){
				System.out.println("Successfully login");
				
				return sub_data;
			}
			j++;
		}
		System.out.println("Account is not exits");
		return null;
	}
	
	
	public void updata_data (String name , int x , int newdata) throws FileNotFoundException 
	{
		ArrayList<String> st;
		st = Store_data();
	
		for(int i=0;i<st.size();i++) 
		{
		   String sub_data[];
		   sub_data = st.get(i).split("-");
		   if(name.equals(sub_data[0])) 
		   {
			   String s = sub_data[0];
			   for(int j=1;j<sub_data.length;j++) 
			   {
				   if(j==x) {
					   
					   int number = Integer.parseInt(sub_data[2]);
					   number = number+newdata;
					   String s1= Integer.toString(number);
					   s = s + "-" + s1;
					   
				   }

				   else 
				   {
					   s = s + "-" + sub_data[j];
				   }
			   }
			   st.set(i,s);
			   write_new_data(st);
			   break;
		   }
	   }
	}
	
	
	public void delete_account(String name) throws FileNotFoundException {
		ArrayList<String> st;
		st = Store_data();
	   for(int i=0;i<st.size();i++) 
	   {
		   String sub_data[];
		   sub_data = st.get(i).split("-");
		   if(name.equals(sub_data[0])) 
		   {
			   st.remove(i);
			   write_new_data(st);
			   break;
		   }
	   }
	}
	
	
	public ArrayList<String> Store_data() throws FileNotFoundException
	{
		Scanner scanner = new Scanner(new File("Login.txt"));
		 ArrayList<String> st = new ArrayList<String>();
		 
		while (scanner.hasNextLine()) 
		{
			st.add(scanner.nextLine());
		}
		
		return st;
	}
	
	
	public void write_new_data(ArrayList<String> st) 
	{
		try (FileWriter f = new FileWriter(new File("Login.txt"));
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);) 
		{ 
			for(int i=0;i<st.size();i++) 
			{
				p.println(st.get(i));
			}
		} 
		catch (IOException i) {
				i.printStackTrace(); 
			}
	}
	
	
}
