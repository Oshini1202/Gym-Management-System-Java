package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface GymManager {

    public void addMember(DefaultMember member);
    public boolean deleteMember(String membershipNo);
    public void printMemberList();
    public List<DefaultMember> sortMemberList();
    public void saveMemberList() throws IOException;
    public List<DefaultMember> getMemberList();
    public DefaultMember getMemberByMembershipNo(String membershipNo);
    public DefaultMember[] getMemberByFullName(String fullName);

}
