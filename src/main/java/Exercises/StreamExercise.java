package Exercises;

import Model.Gender;
import Model.NewPeople;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static Custom.NewPeopleSuppler.newPeopleSupplier;

public class StreamExercise {

    private List<NewPeople> people;

    public StreamExercise(List<NewPeople> people) {
        this.people = people;
    }

    public StreamExercise() {
        this.people = newPeopleSupplier.get();
    }

    public void imperativeApproach() {
        List<NewPeople> femalePeople = new ArrayList<>();
        people.forEach(person -> {
            if (person.gender() == Gender.FEMALE)
                femalePeople.add(person);
        });
        femalePeople.forEach(System.out::println);
    }

    public void declarativeApproach() {
        people.stream()
                .filter(person -> person.gender() == Gender.FEMALE)
                .forEach(System.out::println);
    }

    public String transform(String data) {
       return data.lines().map(line -> {
            if (line.isBlank()) return line;
            String[] fields = line.split(",");
            fields[4] = fields[4].equals("F") ? Gender.FEMALE.toString() : Gender.MALE.toString();
            return String.join(",", fields);
        }).collect(Collectors.joining("\n"));
    }

    public List<NewPeople> getPersonFromData(String data) {
        String formatttedData = transform(data);
        return Arrays.stream(formatttedData.split("\n"))
                .map(StreamExercise::mapToPerson)
                .filter(person -> person.gender() == Gender.FEMALE)
                .filter(person -> person.age() < 20)
                .filter(person -> person.email().endsWith("gov.uk"))
                .toList();
    }

    private static NewPeople mapToPerson(String line) {
        String[] fields = line.trim().split(",");
        return new NewPeople(
                fields[1],
                fields[2],
                Integer.parseInt(fields[0]),
                fields[3],
                Gender.valueOf(fields[4])
        );
    }

    public static Supplier<String> originalData = () -> """ 
                16,Fanchette,Williamson,fwilliamson0@github.com,F
                26,Aleksandr,Matts,amatts1@webs.com,M
                3,Maurie,Cordero,mcordero2@google.co.jp,M
                45,Donnajean,Crowson,dcrowson3@google.com.hk,F
                5,Ricardo,Gofton,rgofton4@nytimes.com,M
                65,Gabie,Tregenna,gtregenna5@guardian.co.uk,F
                37,Marjorie,Blumsom,mblumsom6@joomla.org,F
                18,Lester,Huyghe,lhuyghe7@jugem.jp,M
                39,Merrily,Stangoe,mstangoe8@tiny.cc,F
                10,Reider,Karel,rkarel9@github.io,M
                11,Dory,Jolliff,djolliffa@wufoo.com,F
                32,Homerus,Averay,haverayb@skyrock.com,M
                13,Alyda,Muglestone,amuglestonec@is.gd,F
                14,Pinchas,Louca,ploucad@google.es,M
                11,Cherin,Eltringham,celtringhame@parallels.com,F
                2,Mufi,Rothert,mrothertf@dropbox.com,F
                17,Jordana,Everex,jeverexg@ucla.edu,F
                18,Belle,Rother,brotherh@gov.uk,F
                19,Clevie,Sifflett,csiffletti@furl.net,M
                20,Gretchen,Abell,gabellj@1688.com,F
            """;


    public static void main(String[] args) {
        StreamExercise streamExercise = new StreamExercise();
//        streamExercise.imperativeApproach();
//        System.out.println();
//        streamExercise.declarativeApproach();
        System.out.println("Exercise 2");
        String data = originalData.get();
        List<NewPeople> transformList = streamExercise.getPersonFromData(data);
        transformList.forEach(System.out::println);
    }


}
