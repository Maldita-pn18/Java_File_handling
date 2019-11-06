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
 * @author 2ndyrGroupA
 */
public class AddInformation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        
        System.out.print("Firstname : ");
        String fname = input.nextLine();
        System.out.print("Lastname : ");
        String lname = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Password : ");
        String password = input.nextLine();
        System.out.print("Repeat password : ");
        String repeatPass = input.nextLine();
//        if on another class;;;
//        ClassName <variable> = new ClassName();
//        variable.submit(firstname,middlename,lastname);

        submit(fname,lname,email,password,repeatPass);

        retrieve();
    }

    public static void submit(String fname, String lname, String email, String password, String repeatPass) {
        Path path = Paths.get("C:\\Users\\2ndyrGroupA\\Desktop\\RegisterInformation.txt");

        try {
//            Files.write(path, String.format("%d\t%s\t%s\n", id, username, password).getBytes(), StandardOpenOption.APPEND);
            Files.write(path, (fname + "," + lname + "," + email + "," + password + "," + repeatPass  + "\n").getBytes(), StandardOpenOption.APPEND);
            System.out.println("Details has been added!");
        } catch (RuntimeException re) {
            System.out.println(re);
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    public static void retrieve() {
        String filePath = "C:\\Users\\2ndyrGroupA\\Desktop\\RegisterInformation.txt";
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
        } catch (RuntimeException re) {
            System.out.println(re);
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf);
        } catch (IOException ioe) {
            System.out.println(ioe);
        } finally {
            try {
                reader.close();
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
    }
}
