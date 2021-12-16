package com.example.travelezweb.secure;


import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Convert{
    public Convert (){

    }
    public String ConvertToHexadecimal(int num){
        int r;
        String bin="\0";

        do{
            r=num%16;
            num=num/16;

            if(r==10)
                bin="A"+bin;

            else if(r==11)
                bin="B"+bin;

            else if(r==12)
                bin="C"+bin;

            else if(r==13)
                bin="D"+bin;

            else if(r==14)
                bin="E"+bin;

            else if(r==15)
                bin="F"+bin;

            else
                bin=r+bin;
        }while(num!=0);

        return bin;
    }

    public BigInteger ConvertFromHexadecimalToDecimal(String num){
        BigInteger a = new BigInteger("0");
        Integer ctr = 0;
        BigInteger prod = new BigInteger("0");
        BigInteger sixteen= new BigInteger("16");

        for(int i=num.length(); i>0; i--){

            if(num.charAt(i-1)=='a'||num.charAt(i-1)=='A')
                a= new BigInteger("10");

            else if(num.charAt(i-1)=='b'||num.charAt(i-1)=='B')
                a= new BigInteger("11");

            else if(num.charAt(i-1)=='c'||num.charAt(i-1)=='C')
                a= new BigInteger("12");

            else if(num.charAt(i-1)=='d'||num.charAt(i-1)=='D')
                a= new BigInteger("13");

            else if(num.charAt(i-1)=='e'||num.charAt(i-1)=='E')
                a= new BigInteger("14");

            else if(num.charAt(i-1)=='f'||num.charAt(i-1)=='F')
                a= new BigInteger("15");

            else
                a= new BigInteger(Integer.toString(Character.getNumericValue(num.charAt(i-1))));


            prod = prod.add(a.multiply((sixteen.pow(ctr))));
            ctr++;
        }
        return (BigInteger)prod;
    }

   // public static void main(String[] args){

    //    Convert dh=new Convert();
   //     Scanner s=new Scanner(System.in);
//
    //    int num;
     //   String numS;
    //    int choice;

    //    System.out.println("Enter your desired choice:");
    //    System.out.println("1 - DECIMAL TO HEXADECIMAL             ");
    //    System.out.println("2 - HEXADECIMAL TO DECIMAL              ");
    //    System.out.println("0 - EXIT                          ");
//
     //   do{
     //       System.out.print("\nEnter Choice: ");
      //      choice=s.nextInt();
//
      //      if(choice==1){
        //        System.out.println("Enter decimal number: ");
        //        num=s.nextInt();
         //       System.out.println(dh.ConvertToHexadecimal(num));
         //   }
//
        //    else if(choice==2){
          //      System.out.println("Enter hexadecimal number: ");
          //      numS=s.next();
          //      System.out.println(dh.ConvertFromHexadecimalToDecimal(numS));
         //   }
     //   }while(choice!=0);
   // }
}

