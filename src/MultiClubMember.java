public class MultiClubMember extends SingleClubMember{

    int membershipPoints;

    public MultiClubMember(char memberType, int memberID, String name, double fees, int club, int membershipPoints) {
        super(memberType, memberID, name, fees, club);
        this.membershipPoints = membershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + "," + club + "," + membershipPoints;
    }
}
