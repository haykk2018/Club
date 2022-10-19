import java.util.LinkedList;
import java.io.*;

public class FileHandler {


    void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
            writer.write(mem + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void overwriteFile(LinkedList<Member> m) {
        //we are writing list to temporary file
        //than we are deleting members.csv and renaming temporary file to members.csv
        String s;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {

            for (Member item : m) {
                writer.write((item.toString()) + "\n");
            }

        } catch (IOException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }

        File f = new File("members.csv");
        File tf = new File("members.temp");
        f.delete();
        tf.renameTo(f);
    }

    LinkedList<Member> readFile() {

        LinkedList<Member> m = new LinkedList();
        String lineRead;
        String[] splitLine;
        Member mem;
        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            //loop reed by line to line
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(",");
                mem = MembershipManagement.createMember(splitLine[0], Integer.parseInt(splitLine[1]), splitLine[2],
                        Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                m.add(mem);
                lineRead = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return m;
    }
}
