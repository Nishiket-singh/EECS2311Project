package user;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import Data.*;
import java.util.Random;
class AddingComments {
    public static void main(String[] args)
    {
    	Random rand = new Random();
        // creating the instance of class BufferedReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String comment = null;
        try {
            System.out.println("Post a comment");
            comment = reader.readLine(); // taking string input
            System.out.println(comment);
            
            
        }
        
     
        
        
        catch (Exception e) {
        }
        
    }
}