package com.sda.lambdas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        Predicate<Person> isMajor=person -> person.getAge()>18;

        for(Person temp:people){
            boolean result=isMajor.test(temp);
            if(result){
                System.out.println(temp.getName()+" e major.");
            }else{
                System.out.println(temp.getName()+" nu e major.");
            }
        }

        AdultPersonTest personTest=new AdultPersonTest();
        for(Person temp:people){
            boolean result=personTest.test(temp);
            if(result){
                System.out.println(temp.getName()+" e major.");
            }else{
                System.out.println(temp.getName()+" nu e major.");
            }
        }


        ICalculator calculator=(x,y)->x+y;
        System.out.println(calculator.add(1,2));

        ISalut obiect=()-> {
            String mesaj = "Salut!";
            System.out.println(mesaj);
        };
        ISalut obiect2=()-> System.out.println("Hello world!");
        obiect.greet();
        obiect2.greet();
    }

    public static List<Person> getPeople() {
        Person gigel=new Person("Gigel",18);
        Person dorel=new Person("Dorel",15);
        Person ionel=new Person("Ionel",22);

        List<Person> people=new LinkedList<>();
        people.add(gigel);
        people.add(dorel);
        people.add(ionel);
        return people;
    }
}
