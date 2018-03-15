package service;

import model.Result;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    private static ArrayList<Result> results;

    public static void main(String[] args) {

        int choice = 0;
        do{
            System.out.println("Wellcome to the Star Wars App -- Main Menu");
            System.out.println("1. Load the adventure");
            System.out.println("0. Exit");

            System.out.println("");
            System.out.println("Enter the number of your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice){
                case 0: quit(); break;
                case 1: adventure(); break;
                default: System.out.println("");System.out.println("Wrong choice. Enter Again: "); break;
            }

        }while(choice != 0);
    }

    private static void quit(){
        exit(0);
    }

    private static void adventure(){
        String heroName;
        int cargo;
        String planetName;

        System.out.println("");
        System.out.println("Enter character's name you want to use: ");
        Scanner sc = new Scanner(System.in);
        heroName = sc.nextLine();
        System.out.println("Enter the destination planet's name: ");
        planetName = sc.nextLine();
        System.out.println("Enter a cargo weight in kg: ");
        cargo = sc.nextInt();

        if(validationInput(heroName,cargo,planetName)) {
            //load data
            LoadAndComputeData loadAndComputeData = new LoadAndComputeData();
            loadAndComputeData.readJson();
            //compute
            loadAndComputeData.construct(heroName,cargo,planetName);
            results = loadAndComputeData.getResults();
            //display result
            System.out.println("---------------------------------------------------------------------------");
            System.out.println(heroName+", can transport a cargo of "+cargo+" kg to "+planetName+" in: ");
            for(Result r : results){
                System.out.println(r.getTotalTimeTransport()+" hours, using the "+r.getShipName()+" in "+r.getNumberTrips()+" trips");
            }
        }

        exit(0);

    }

    private static boolean validationInput(String heroName, int cargo, String planetName){
        boolean valid = false;

        if((heroName != null || !heroName.equals("")) && (planetName != null || !planetName.equals("")) && cargo > 0){
            valid = true;
        }
        return valid;
    }

}
