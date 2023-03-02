package homework4_person;

import java.time.Year;

public class Person {
    private String name;
    private String middleName;
    private String familyName;
    private int age;

    public Person(String name, String middleName, String familyName, int age) {
        this.name = name;
        this.middleName = middleName;
        this.familyName = familyName;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (!middleName.isEmpty()) {
            this.middleName = middleName;
        }
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        if (!familyName.isEmpty()) {
            this.familyName = familyName;
        }
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        }
    }

    public int dateBirth() {
        return (Year.now().getValue()) - age;
    }

    @Override
    public String toString() {
        return "{" + name + " " + middleName + " " + familyName + " " + age + "}";
    }
}
