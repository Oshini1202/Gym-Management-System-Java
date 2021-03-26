package sample;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Console{
    private final static MyGymManager gymManager = new MyGymManager();  // creating a object called gymManager
    private static int memCount = 0;                                    // at the beginning of the program keep the member count to zero

    public static void main(String[]args) throws IOException {

        Scanner sc_248 = new Scanner(System.in);
        int optionNo;

        // create the menu console
        do {
            System.out.println("__________________Gym Management System__________________________\n");
            System.out.println("Please enter:");
            System.out.println(" 1\tAdd a new member");
            System.out.println(" 2\tDelete a member");
            System.out.println(" 3\tPrint the list of members");
            System.out.println(" 4\tSort the members");
            System.out.println(" 5\tWrite/Save to text file");
            System.out.println(" 6\tTable view and search member");
            System.out.println(" 7\tExit program\n");
            System.out.print("User input : ");
            //validate if the user input invalid input
            while (!sc_248.hasNextInt()) {
                System.out.println("Invalid Input !\nPlease enter a number 1 - 6 ");
                System.out.print("Select Option: ");
                sc_248.next();
            }

            optionNo = sc_248.nextInt();
            switch (optionNo) {
                case 1:
                    addingMembers();             // call the method for add members
                    break;
                case 2:
                    deleteMember();              // call the method for delete members
                    break;
                case 3:
                    gymManager.printMemberList();  // call the method for print members
                    break;
                case 4:
                    gymManager.sortMemberList();  // call the method for sort members
                    break;
                case 5:
                    gymManager.saveMemberList();  // call the method for save members
                    break;
                case 6:
                    viewMemListAndSearch();       // call the method for open gui and view and search members
                    break;
                case 7:
                    System.out.println("******* Exit *******");  // exit from the program
                    System.out.println("Have a nice day !");
                    System.exit(0);
                    break;
            }

        } while (optionNo > 1 || optionNo < 7);  // repeat the menu while member is entering a valid input
    }

    // method for add members
    private static void addingMembers(){
        Scanner sc_248 = new Scanner(System.in);

        if (memCount <100){   // keep the limitation of adding members to the gym management system below 100
            System.out.print("Please enter the no of members that you are going to add  : ");  // let know how many times the user going to add members
            int noOfMembers = sc_248.nextInt();


            for (int i = 0; i < noOfMembers; i++) {
                System.out.println("--------------------Add Member---------------------------\n");
                System.out.print("Enter the full name of the member (with initials) : ");                 // get the full name of the member as an input
                String fullName = sc_248.next();
                System.out.print("Enter the membership number of the new member : ");                     // get the membership no as an input
                String membershipNo = sc_248.next();
                membershipNo.toUpperCase();                                                               // convert membership number to uppercase
                System.out.print("Enter the start membership date of the new member (DD MM YYYY) : ");    // get the start membership date as an input
                int dayOfDate = sc_248.nextInt();                                                         // get the day of start membership date as input
                int monthOfDate = sc_248.nextInt();                                                       // get the month of start membership date as input
                int yearOfDate = sc_248.nextInt();                                                        // get the year of start membership date as input
                Date startMembershipDate = new Date(dayOfDate,monthOfDate,yearOfDate);

                System.out.print("Enter the contact number of member : ");                                // get the member contact number as an input
                int memContactNo = sc_248.nextInt();
                System.out.print("Enter the member height in cm: ");                                     // get the member height as an input
                int memHeight = sc_248.nextInt();
                System.out.print("Enter the member weight in kg : ");                                     // get the member weight as an input
                double memWeight = sc_248.nextDouble();

                // get member type as input
                System.out.println("Please enter : \n");
                System.out.println("1\tDefault member");
                System.out.println("2\tStudent member");
                System.out.println("3\tOver 60 member");
                System.out.print("User input : ");
                int memType = sc_248.nextInt();

                DefaultMember gymMember = null;


                switch (memType) {
                    case 1:
                        // store the data of default member as a new gymMember object
                        gymMember = new DefaultMember(membershipNo, fullName, startMembershipDate,memContactNo,memHeight,memWeight);
                        break;

                    case 2:
                        System.out.print("Enter the school name of the member : ");
                        String memSchoolName = sc_248.next();
                        // store the data of student member as a new gymMember object
                        gymMember = new StudentMember(membershipNo, fullName, startMembershipDate, memSchoolName,memContactNo,memHeight,memWeight);
                        break;

                    case 3:
                        System.out.print("Enter age of the member : ");
                        int memAge = sc_248.nextInt();
                        // store the data of over 60 member as a new gymMember object
                        gymMember = new Over60Member(membershipNo, fullName, startMembershipDate, memAge,memContactNo,memHeight,memWeight);
                        break;

                    default:
                        System.out.println("Invalid Input !!!");   // let the user know if it is a invalid input
                }

                gymManager.addMember(gymMember);
                memCount++;      // increase the member count by one
            }

        }else{
            System.out.println("There is no any slot for new member !");     // let the user know if there's no any slot for a new member
        }


    }

    // method for delete members
    private static void deleteMember(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the membership number : ");  // get the membership number as input to remove the perticular user from the system
        String membershipNo = sc.next();
        boolean result = gymManager.deleteMember(membershipNo);
        if (result){
            memCount--;       // decrease the member count by one
        }
    }

    // method for view list of members and search them through a gui
    public static void viewMemListAndSearch(){
        GUI viewMemListSearch = new GUI();

        Method[] memList = GUI.class.getMethods();
        try{
            javafx.application.Application.launch(GUI.class);
            memList[0].invoke(viewMemListSearch);
        }catch (Exception e){
            System.out.println("Wrapper exception "+e);
            System.out.println("Underlying exception "+e.getCause());
        }

    }


}
