/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 *
 * @author cordotoma_sd2081
 */
public class AddUser {


     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        
        System.out.print("Username : ");
        String Username = input.nextLine();
        System.out.print("Password : ");
        String Password = input.nextLine();
       
//        if on another class;;;
//        ClassName <variable> = new ClassName();
//        variable.submit(firstname,middlename,lastname);
       
        submit(Username,Password);    
       
        retrieve();
    }
   
    public static void submit(String first, String pass){
        Path path = Paths.get("C:\\Users\\2ndyrGroupA\\Desktop\\\\Users.txt");
       
        try {
//            Files.write(path, String.format("%d\t%s\t%s\n", id, username, password).getBytes(), StandardOpenOption.APPEND);
             Files.write(path, (first+","+pass+"\n").getBytes(),StandardOpenOption.APPEND);
            System.out.println("Details has been added!");
        } catch(RuntimeException re){
            System.out.println(re);
        } catch(IOException ie){
            System.out.println(ie);
        }
    }
   
    public static void retrieve(){
        String filePath = "C:\\Users\\2ndyrGroupA\\Desktop\\\\Users.txt";
        String line = null;
        BufferedReader reader = null;
        FileReader freader = null;
//
        try {
            freader = new FileReader(filePath);
            reader = new BufferedReader(freader);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch(RuntimeException re){
            System.out.println(re);
        }catch(FileNotFoundException fnf){
            System.out.println(fnf);
        }catch(IOException ioe){
            System.out.println(ioe);
        }finally{
            try{
                reader.close();
            }catch(IOException ioe){
                System.out.println(ioe);
            }
        }
    }
}
