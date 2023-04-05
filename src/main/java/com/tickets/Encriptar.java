package com.tickets;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

    public static void main(String[] args) {
        var codigo = new BCryptPasswordEncoder();
        System.out.println("Gustavo (123): " + codigo.encode("123"));
        System.out.println("Adriela (456): " + codigo.encode("456"));
        System.out.println("Ronal (789): " + codigo.encode("789"));

    }
}
