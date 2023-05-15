package com.class2;

import com.class1.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonManagement personManagement = new PersonManagement();
        int chose = 0;
        Scanner input = new Scanner(System.in);
        try {
            do {
                System.out.println("1. Add new Person");
                System.out.println("2. view all Person");
                System.out.println("3. Get Person by ID");
                System.out.println("4. Update Person by ID");
                System.out.println("5. Delete Person by ID");
                System.out.println("6. Exit");
                System.out.println("Choose: ");

                chose = input.nextInt();
                switch (chose){
                    case 1:{
                        Person person = new Person();
                        person.inputData();
                        personManagement.addNewPerson(person);
                    }
                    break;
                    case 2:{
                        personManagement.getAllPerson();
                    }
                    break;
                    case 3:{
                        System.out.println("Enter person by id: ");
                        int id = input.nextInt();
                        Person person = personManagement.getPersonById(id);
                        if (person != null){
                            System.out.println(person.toString());
                        }else {
                            System.out.println("Not found ");
                        }
                    }
                    break;
                    case 4:{
                        System.out.println("Enter person by id: ");
                        int id = input.nextInt();
                        personManagement.updateStudent(id);
                    }
                    break;
                    case 5:{
                        System.out.println("Enter person by id: ");
                        int id = input.nextInt();
                        personManagement.deletePerson(id);
                    }
                }
            }while (true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
