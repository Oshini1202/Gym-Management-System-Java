package sample;


public class DefaultMember implements Comparable<DefaultMember>{
    private String membershipNo;
    private String fullName;
    private Date startMembershipDate;
    private int memContactNo;
    private int memHeight;
    private double memWeight;

    public DefaultMember(String membershipNo, String fullName , Date startMembershipDate, int memContactNo, int memHeight, double memWeight){
        super();
        this.membershipNo = membershipNo;
        this.fullName = fullName;
        this.startMembershipDate = startMembershipDate;
        this.memContactNo = memContactNo;
        this.memHeight = memHeight;
        this.memWeight = memWeight;
    }

    // get method for membership Number
    public String getMembershipNo(){
        return membershipNo;
    }

    // set method for membership Number
    public void setMembershipNo(String membershipNo){
        this.membershipNo = membershipNo;
    }

    // get method for member full name
    public String getFullName(){
        return fullName;
    }

    // set method for member full name
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    // get method for the membership start date of the member
    public Date getStartMembershipDate(){
        return startMembershipDate;
    }

    // set method for the membership start date of the member
    public void setStartMembershipDate(Date startMembershipDate){
        this.startMembershipDate = startMembershipDate;
    }

    // get method for
    public int getMemContactNo(){
        return memContactNo;
    }

    public void setMemContactNo(int memContactNo){
        this.memContactNo =memContactNo;
    }

    public int getMemHeight(){
        return memHeight;
    }

    public void setMemHeight(int memHeight){
        this.memHeight =memHeight;
    }

    public double getMemWeight(){
        return memWeight;
    }

    public void setMemWeight(double memWeight){
        this.memWeight = memWeight;
    }

    @Override
    public int compareTo(DefaultMember o) {
        return this.fullName.compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        return "DefaultMember{" +
                "membershipNo='" + membershipNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", startMembershipDate='" + startMembershipDate + '\'' +
                ", memContactNo=" + memContactNo +
                ", memHeight=" + memHeight +
                ", memWeight=" + memWeight +
                '}';
    }
}
