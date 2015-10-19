import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by holdenhughes on 10/19/15.
 */
public class People {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Person>> people = new HashMap();
        String content = readFile("people.csv");
        String[] lines = content.split("\n");
        int i=0;


        for (String line : lines) {
            if (i !=0) {
                String[] columns = line.split(",");
                String country = String.valueOf(columns[4]);
                ArrayList<Person> list = people.get(country);

                String id = columns[0];
                String firstName = columns[1];
                String lastName = columns[2];
                String email = columns[3];
                String countryName = columns[4];
                String ip = columns[5];

                Person person = new Person(id, firstName, lastName, email, countryName, ip);


                if (list == null) {
                    list = new ArrayList();
                    list.add(person);
                    people.put(country, list);
                } else {
                    list.add(person);
                }
                Collections.sort(list);
            }

            i++;
        }

        System.out.println(people);

    }

    static String readFile(String fileName){
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e){
            return null;
        }
    }

}
