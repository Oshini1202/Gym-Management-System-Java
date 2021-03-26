package sample;

import java.io.*;
import java.util.*;

public class MyGymManager implements GymManager{

    static List<DefaultMember> listOfMembers = new ArrayList<DefaultMember>();     // create a array list to store the member data



    //************************************************************  add members  ************************************************************//

    @Override
    // method for add members
    public void addMember(DefaultMember member) {
        System.out.println("Number of spaces already taken : "+(listOfMembers.size()+1));        // print the number of spaces already taken
        System.out.println("Number of spaces available : "+(100 - (listOfMembers.size()+1)));    // print the available spaces

        if (listOfMembers.size() < 100){                   // check whether if the size of listOfMembers less than 100
            listOfMembers.add(member);                     // if the size od array less than 100 then add members to the array list
        }else{
            System.out.println("There\'s no spaces available for new members !!!");     // let the user know the size of the array greater than or equal to 100
        }
    }


    //********************************************************  delete members *****************************************************************//

    @Override
    // method for delete members
    public boolean deleteMember(String membershipNo) {
        boolean checkMembershipNo = false;                              // set the boolean flag to false
        for (DefaultMember member : listOfMembers){
            if (member.getMembershipNo().equals(membershipNo)){         // if the membership no which input by the user to delete is already in the array list continue the deleting process
                checkMembershipNo=true;                                 // set the boolean flag to true
                listOfMembers.remove(member);                           // remove the member details from the array list
                System.out.println("Member who is with membership number "+membershipNo+" has removed successfully !");  // let the user know if the member deleted from the list
                System.out.println("Number of spaces already taken : "+listOfMembers.size());
                System.out.println("Number of spaces available : "+(100 - listOfMembers.size()));
                if(member instanceof StudentMember){                    // print the type of deleted member
                    System.out.println("Type of the membership : Student Member");
                }else if (member instanceof Over60Member){
                    System.out.println("Type of the membership : Over 60 member");
                }else{
                    System.out.println("Type of the membership : Default member");
                }
                break;
            }
        }

        if(!checkMembershipNo){
            System.out.println("Membership number not found . Please try again !");   // if the membership number doesn't match with the member list let know the user

        }
        return checkMembershipNo;

    }

    //***************************************************** print member list  **********************************************************//

    @Override
    // method for print member list
    public void printMemberList() {
        System.out.println("\n******************  Gym Member List  **********************\n");
        for (DefaultMember member : listOfMembers){                                                          // print the details of a default member
            System.out.println("\n========================================================\n");
            System.out.println("Membership Number : "+member.getMembershipNo()+" ");
            if (member instanceof StudentMember){                                                           // print the details of a student member
                System.out.println("Type of the membership : Student Member");
                System.out.println("School of the member : "+((StudentMember) member).getMemSchoolName());
            }else if (member instanceof Over60Member){                                                      // print the details of a over 60 member
                System.out.println("Type of the membership : Over 60 member");
                System.out.println("Member age : "+((Over60Member) member).getMemAge());
            }else{
                System.out.println("Type of the membership : Default member");
            }
            System.out.println("Member name : "+member.getFullName()+" ");
            System.out.println("Membership start date : "+member.getStartMembershipDate());
            System.out.println("Member contact number : "+member.getMemContactNo());
            System.out.println("Height of the member : "+member.getMemHeight()+" cm");
            System.out.println("Weight of the member : "+member.getMemWeight()+" kg");
            System.out.println("\n========================================================\n");
        }
        if (listOfMembers.size()==0){
            System.out.println("List is empty");                  // let the user know if the list is empty
        }

    }

    //************************************************  sort the member list  ************************************************************//

    @Override
    // method for sort the member list by their full name in ascending order
    public List<DefaultMember> sortMemberList() {
        DefaultMember[] array = listOfMembers.toArray(new DefaultMember[]{});
        Arrays.sort(array);
        List<DefaultMember> sortedArrayList = Arrays.asList(array);
        System.out.println("----------------------- Sorted member list -------------------------\n");
        for(DefaultMember dMem : sortedArrayList){

            System.out.println(dMem.getFullName());

        }
        System.out.println("======================================================================");
        return sortedArrayList;                      // return the sorted array list
    }


    //************************************************  save the member list  ***********************************************************//

    @Override
    // method for save member details toa text file
    public void saveMemberList() throws IOException{

        File file = new File("GymMemberDetails.txt");
        FileWriter fileW = new FileWriter(file,true);
        PrintWriter fileP = new PrintWriter(fileW,true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to save your data to a file \n");
        System.out.println("1\tYes");
        System.out.println("2\tNo");
        System.out.print("User input : ");
        int saveMember = scanner.nextInt();

        // write the member details to a file
        for (DefaultMember member : listOfMembers){
            if (saveMember == 1){
                fileP.write("Membership number "+member.getMembershipNo()+" | "+
                        "Full name : "+member.getFullName()+" | "+
                        "Start membership date : "+member.getStartMembershipDate()+" | "+
                        "Contact number : "+member.getMemContactNo()+" | "+
                        "Member height (cm) : "+member.getMemHeight()+" | "+
                        "Member weight (kg) : "+member.getMemWeight()+" | ");
                fileP.println();
            }else if (saveMember == 2){
                System.out.print("Nothing saved to a file ! ");
            }else{
                System.out.println("Invalid input ! ");                     // let the user know if he input an invalid input
            }
        }


    }

    @Override
    public List<DefaultMember> getMemberList() {
        return this.listOfMembers;
    }

    @Override
    public DefaultMember getMemberByMembershipNo(String membershipNo) {
        return null;
    }

    @Override
    public DefaultMember[] getMemberByFullName(String fullName) {
        return new DefaultMember[0];
    }



}
