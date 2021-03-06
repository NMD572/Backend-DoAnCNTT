package com.example.travelezweb.secure;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA512 {
    private  int BUFFER_SIZE = 32 * 1024;

    public SHA512() {
    }
    //public static void main(String args[]) throws NoSuchAlgorithmException
    //{

    //    System.out.println("HashCode Generated by SHA-512 for: ");

    //   String s1 = "GeeksForGeeks";
    //   System.out.println("\n" + s1 + " : " + encryptThisString(s1));

    //   String s2 = "872703378de1ecc14225c53d1c68e7c43f4916e43061cd118451e1b2c29e7eb7713b9bada087dc2dbebb226b0975b4601c219b59db454e438b21f835ca2b1abc58971069708950169517965373643533485407432871176902791374793331373131945299080";
    //   System.out.println("\n" + s2 + " : " + encryptThisString(s2));
    // }

    public BigInteger md(String f) throws Exception {
        BufferedInputStream file = new BufferedInputStream(new FileInputStream(f));
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        DigestInputStream in = new DigestInputStream(file, md);
        int i;
        byte[] buffer = new byte[BUFFER_SIZE];
        do {
            i = in.read(buffer, 0, BUFFER_SIZE);
        } while (i == BUFFER_SIZE);
        md = in.getMessageDigest();

        in.close();


        return new BigInteger(md.digest());
    }
    public  String encryptThisString(String input)
    {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}

