package com.sda.lambdas.streams;

import com.sda.lambdas.Person;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Person> people=com.sda.lambdas.Main.getPeople();

        for (int i = 0; i < people.size(); i++) {
            Person person=people.get(i);
            String name=person.getName();
            System.out.println(name);
        }

        for(Person temp:people){
            String name=temp.getName();
            System.out.println(name);
        }

        String[] array={"1","2"};
        //operatie initiala
        Stream<Person> stream=people.stream();
        Stream<String> streamDeArray=Stream.of(array);

        //operatii terminale
        List<String> strings = streamDeArray.collect(toList());

        //operatii intermediare
        //map si filter

        //vreau sa afisez doar varstele sub 18 ani
        for(Person temp:people){
            Integer varsta=temp.getAge();
            if(varsta<18){
                String name=temp.getName();
                System.out.println(name);
            }
        }

        List<Integer> collect=people.stream()
                //map imi intoarce si trimite mai departe de pe obiectul primit(persoana)
                // valoarea din getAge()
                .map(person->person.getAge())
                //filter imi trimite mai departe doar intrarile care respecta
                //conditia varsta<18
                .filter(age->age<18)
                //peek ma lasa sa am o operatiune intermediara unde
                //am acces la date sysout
                .peek(age-> System.out.println(age))
                //collect imi intoarce valorile care au ajuns aici(mapate si filtrate
                //intr-o colectie noua
                .collect(toList());

        Predicate<Integer> isUnderAged = age -> age < 18;
        List<Integer> collect1=people.stream()
                .map(Person::getAge)
                .filter(isUnderAged)
                .peek(System.out::println)
                .collect(toList());

        //vreau sa aflu daca Ionel este in lista
        Optional<String> isIonelPresent=people.stream()
                .map(Person::getName)
                .filter(name->name.equals("Ionel"))
                .findAny();
        isIonelPresent.ifPresent(string-> System.out.println("e prezent"));
    }
}
