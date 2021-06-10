package People;

public class Person {

    private String name;
    private int age;
    private String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }
    //only necessary if we want the name to be updated
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    //only necessary if we want the country to be updated
    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }
    // only necessary if we want to update the age
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", from " + country;
    }

}
