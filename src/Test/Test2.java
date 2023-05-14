package Test;

import Restaurant.Restaurant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Test2 {
    public static void main(String[] args){
        String test = "Rating: 3/5";
        String[] test2 = test.split("");
        System.out.println(test2[8]);
        System.out.println(test2[1]);
    }
}
