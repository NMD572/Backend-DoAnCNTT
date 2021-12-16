package com.example.travelezweb.controller;

import com.example.travelezweb.model.PublicKey;
import com.example.travelezweb.repository.PublicKeyRepository;

import com.example.travelezweb.secure.AlgorithmRSA;
import com.example.travelezweb.secure.Convert;
import com.example.travelezweb.secure.SHA512;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PublicKeyController {
    final
    PublicKeyRepository publicKeyRepository;
    public PublicKeyController(PublicKeyRepository publicKeyRepository) {
        this.publicKeyRepository = publicKeyRepository;
    }
    @PutMapping("/publickey/{id}")
    public ResponseEntity<PublicKey> updateKey(@PathVariable("id") int id, @RequestBody PublicKey publicKey) {
        Optional<PublicKey> keyData = publicKeyRepository.findById(id);

        if (keyData.isPresent()) {
            PublicKey _publickey = keyData.get();
            _publickey.setN(publicKey.getN());
            _publickey.setE(publicKey.getE());
            return new ResponseEntity<>(publicKeyRepository.save(_publickey), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/publickey/get/{input}")
    public ResponseEntity<PublicKey> sha(@PathVariable String input) {
        try {

            Integer id =1807;
            Optional<PublicKey> keyData = publicKeyRepository.findById(id);

            PublicKey  publicKey = keyData.get();
            String keye= publicKey.getE();
            String keyn= publicKey.getN();
            // set xong khoa cong khai
            SHA512 sha512= new SHA512();
            String message1 = input.substring(0,40); // lay ra thong diep de hash
            String message2 = input.substring(40,input.length()); // lay ra chuky
            String result = sha512.encryptThisString(message1); //hash xong ra hex
            System.out.print( "mess1:"+message1+"\n");
            System.out.print( "input:"+input+"\n");
            System.out.print( "ms2:"+message2+"\n");
            //convert qua biginteger
           Convert convert = new Convert();
          BigInteger resultBigint= convert.ConvertFromHexadecimalToDecimal(result);//chuyen lai sang bigint de so sanh voi giai ma
            System.out.print( "hash ra:"+resultBigint+"\n");

            String susses = "chu ky toan ven\n" +result;
            String fail =" chu ky khong toan ven\n" +result;

            //String a = "fbd0285a14748522f9a616ab248d549ed3a303e7";//ket qua da giai ma
           // String input2 ="90248026263924768460756107001886727356056137717957829504308570431190835391567";// chu ky // lay tu input nen k can

            AlgorithmRSA rsa = new AlgorithmRSA();
            //BigInteger d = new BigInteger("234630916261360392834842615651761451247803712763135089406385834171243183858789");
           //  BigInteger n = new BigInteger("264516286913055506767558328019606737505847761281917917597907989698958671745211");
           // BigInteger e= new BigInteger("137008551834669115827457181967221129093");//(n,e) la khoa cong khai

           BigInteger n = new BigInteger(keyn);
           BigInteger e= new BigInteger(keye);//(n,e) la khoa cong khai
            BigInteger message = new BigInteger(message2); // dau vao chu ky so
            System.out.print( "n:"+keyn+"\n");
            System.out.print("e:"+keye +"\n");//giai ma
            System.out.print("message:"+message+"\n");//giai ma
           // System.out.print( "phien ma:"+rsa.encrypt(resultBigint,d,n)+"\n");
            System.out.print("dich ma:"+rsa.decrypt(message,e,n));//giai ma

            if (resultBigint.equals(rsa.decrypt(message,e,n))) {
                return new ResponseEntity<>(publicKey, HttpStatus.OK);
            } else {
                return new ResponseEntity<>( HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
