package sample;

public class StudentMember extends DefaultMember {

    private String memSchoolName;

    public StudentMember(String membershipNo, String fullName, Date startMembershipDate ,String memSchoolName,int memContactNo,int memHeight,double memWeight) {
        super(membershipNo, fullName, startMembershipDate,memContactNo,memHeight,memWeight);
        this.memSchoolName = memSchoolName;
    }

    public String getMemSchoolName(){
        return memSchoolName;
    }

    public void setMemSchoolName(String memSchoolName){
        this.memSchoolName = memSchoolName;
    }

}
