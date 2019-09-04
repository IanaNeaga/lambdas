package com.sda.lambdas.optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
//        String text="abc";
        String text=null;
        Optional<String> stringOp=Optional.ofNullable(text);

        if(stringOp.isPresent()){
            System.out.println("Contine text");
        }else{
            System.out.println("Nucontine nimic");
        }

        System.out.println(stringOp.orElse("cde"));
        System.out.println(stringOp.orElseGet(()->"cde"));

        stringOp.orElseThrow(()->new IllegalArgumentException());
//        stringOp.orElseThrow(IllegalArgumentException::new);

        stringOp.ifPresent(string-> System.out.println(string));
//        stringOp.ifPresent(System.out::println);
    }
}
