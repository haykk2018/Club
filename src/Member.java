public class Member {

    char memberType;
    int memberID;
    String name;
    double fees;

    public Member(char memberType, int memberID, String name, double fees) {
        this.memberType = memberType;
        this.memberID = memberID;
        this.name = name;
        this.fees = fees;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getFees() {
        return fees;
    }

    @Override
    public String toString() {
        return memberType +
                ", " + memberID +
                ", " + name  +
                ", " + fees;
    }
}
