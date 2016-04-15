package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;


/**
 * The sole purpose of this library is to present a random joke.  There are 100 jokes in the library and they are
 * formatted in HTML.
 * @author Dr. Ken
 */
public class Jester {
    public String tellAJoke(){
        String joke = null;
        long numJoke = 60;

        do{
            //Get a random number between 1 and 60
            numJoke = Math.round(numJoke * Math.random());
        }while(numJoke < 1);


        System.out.println("---->"+numJoke);

        StringBuilder sb = new StringBuilder();

        try{

            InputStream in = Jester.class.getClassLoader().getResourceAsStream("init" + numJoke + ".html");
            Reader fr = new InputStreamReader(in, "utf-8");

            BufferedReader bufferedReader = null;

            try {
                bufferedReader = new BufferedReader(fr);
                String currentLine = null;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    sb.append(currentLine);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                bufferedReader.close();
            }

            joke = sb.toString();

        }catch (Exception e){
            joke = "I don't know any jokes!";
        }
        return joke;
    }
}
