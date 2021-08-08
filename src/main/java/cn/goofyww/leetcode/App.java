package cn.goofyww.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        long number = 0L;
        String str = null;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while((str = br.readLine())!=null){
                number = Long.parseLong(str);
                for(int i=2;i<=Math.sqrt(number);i++){
                    while(number % i == 0){
                        number /=i;
                        System.out.print(i + " ");
                    }
                }
                if(number > 1){
                    System.out.print(number + " ");
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}