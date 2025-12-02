package br.ufm.feira.service;
import java.util.Random;
public class SMSService {
    public String sendCode(String celular) {
        String code = String.format("%04d", new Random().nextInt(10000));
        System.out.println("(Simulated) Enviando SMS para " + celular + ": codigo=" + code);
        return code;
    }
}
