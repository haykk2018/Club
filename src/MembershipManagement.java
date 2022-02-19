import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;

        while (choice == 0) {
            try {
                //System.out.println("please enter integer number");
                choice = reader.nextInt();
                if (choice == 0)
                    throw new InputMismatchException();
                reader.nextLine();
            } catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println(e);
                System.out.print("\nERROR: INVALID INPUT. Please try again: ");
            }
        }

        return choice;
    }

    void printClubOptions() {
        System.out.println("1) Club Mercury\n" +
                "2) Club Neptune\n" +
                "3) Club Jupiter\n" +
                "4) Multi Clubs");

    }

    int getChoice() {
        int choice;
        System.out.println("WELCOME TO OZONE FITNESS CENTER\n" +
                "================================\n" +
                "1)Add Member\n" +
                "2)Remove Member\n" +
                "3)Display Member Information\n" +
                "Please select an option (or Enter '- 1' to quit)");
        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.println("please enter visitor name");
        name = reader.nextLine();
        printClubOptions();
        System.out.println("please enter the option of the club that is available for you.");
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.println("Please enter a number from 1 to 4;");
            club = getIntInput();
        }
        if (m.size() > 0)
            memberID = m.getLast().getMemberID() + 1;
        else
            memberID = 1;
//        cal = (n)-> {
//            switch (n)
//            {
//                case 1:
//                    return 900;
//                case 2:
//                    return 950;
//                case 3:
//                    return 1000;
//                default:
//                    return -1;
//            }
//        };
        cal = new Calculator<Integer>() {
            @Override
            public double calculateFees(Integer n) {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    case 4:
                        return 1200;
                    default:
                        return -1;
                }
            }
        };
        fees = cal.calculateFees(club);
        if (club != 4) {
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Single Club Member added\n");
        } else {
            mbr = new MultiClubMember('M', memberID, name, fees, club, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: MultiClub Member added\n");
        }
        return mem;
    }

    void removeMember(LinkedList<Member> m) {
        int memberID;
        System.out.println("Please enter a number ID");
        memberID = getIntInput();
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                m.remove(i);
                System.out.println("visitor removed");
                // so as will not to continue the loop
                return;
            }
        }
    }

    void printMemberInfo(LinkedList<Member> m) {
        int memberID;
        //array size there isn't dynamic, we have to set size by declaration
        String[] memberInfo = new String[5];
        System.out.println("Please enter a number ID");
        memberID = getIntInput();
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                memberInfo = m.get(i).toString().split(",");
            }
        }
        System.out.println("Member Type = " + memberInfo[0]);
        System.out.println("Member ID = " + memberInfo[1]);
        System.out.println("Member Name = " + memberInfo[2]);
        System.out.println("Membership Fees = " + memberInfo[3]);
        System.out.println("Membership Points = " + memberInfo[4]);
    }
}
