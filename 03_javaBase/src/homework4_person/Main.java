package homework4_person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Jonatan", "Smith", 45);
        System.out.println(person.getName() + "'s birth year is " + person.dateBirth());
    }
}
