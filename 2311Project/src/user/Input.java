package user;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import Data.*;
import java.util.Random;
class Input {
    public static void main(String[] args)
    {
    	Random rand = new Random();
        // creating the instance of class BufferedReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String username, password, categories = null;
        try {
            System.out.println("Enter your username");
            username = reader.readLine(); // taking string input
            System.out.println("Enter your password");
            password = reader.readLine();
            System.out.println("Choose category: 1)Business 2)Entertainment 3)General 4)Health 5)Science 6)Sports 7)Technology") ;
            categories = reader.readLine();
            
        }
        
     
        
        
        catch (Exception e) {
        }
        
   if(categories.equals("Business") || categories.equals("business") || categories.equals("1") ) {
	   System.out.println(Data.Business.stringB.get(rand.nextInt(3)));
	    }
   else if(categories.equals("Entertainment") || categories.equals("entertainment") || categories.equals("2") ) {
	   System.out.println(Data.Entertainment.stringB.get(rand.nextInt(3)));;
    }
   else if(categories.equals("General") || categories.equals("general") || categories.equals("3") ) {
	   System.out.println(Data.General.stringB.get(rand.nextInt(3)));;
}
   else if(categories.equals("Health") || categories.equals("health") || categories.equals("4") ) {
	   System.out.println(Data.Health.stringB.get(rand.nextInt(3)));;
}
   else if(categories.equals("Science") || categories.equals("science") || categories.equals("5") ) {
	   System.out.println(Data.Science.stringB.get(rand.nextInt(3)));;
}
   else if(categories.equals("Sports") || categories.equals("sports") || categories.equals("6") ) {
	   System.out.println(Data.Sports.stringB.get(rand.nextInt(3)));;
}
   else if(categories.equals("Technology") || categories.equals("technology") || categories.equals("7") ) {
	   System.out.println(Data.Technology.stringB.get(rand.nextInt(3)));;
}
   else {
	   System.out.println("Error: no such category");
   }
   
}
}