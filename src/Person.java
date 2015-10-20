/**
 * Created by holdenhughes on 10/19/15.
 */
public class Person implements Comparable{
    String id;
    String firstName;
    String lastName;
    String email;
    String countryName;
    String ip;

    public Person(String id, String firstName, String lastName, String email, String countryName, String ip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.countryName = countryName;
        this.ip = ip;
    }

    @Override //these overrides are a pain to remember
    public int compareTo(Object o) {
        Person p = (Person) o;
        int result = lastName.compareTo(p.lastName);
        return result;
    }

    @Override
    public String toString(){
        return String.format("%s %s from %s", firstName, lastName, countryName); // doesn't get rid of key and looks dumb
    }
}
