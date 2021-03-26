package sample;

public class Over60Member extends DefaultMember{
    int memAge;


    public Over60Member(String membershipNo, String fullName, Date startMembershipDate , int memAge, int memContactNo, int memHeight, double memWeight) {
        super(membershipNo, fullName, startMembershipDate,memContactNo,memHeight,memWeight);
        setMemAge(memAge);
    }

    public int getMemAge(){
        return memAge;
    }

    private void setMemAge(int memAge) {
        if (memAge >= 60){                           // check whether if the over 60 member age input is over 60 or not
            this.memAge = memAge;
        }else{
            throw new IllegalArgumentException("Invalid age input. The input should be over 60 !!!");  // let the user know if the age of over 60 member isn't grater than 60
        }
    }

    @Override
    public String toString() {
        return "Over 60 member{" +
                "Age of the member ='" + memAge +
                '}';
    }
}
