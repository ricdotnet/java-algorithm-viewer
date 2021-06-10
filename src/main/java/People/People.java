package People;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class People {

    private List<Person> peopleList = new ArrayList<Person>();

    public People() {}
    static People people = new People();

    public static void main(String args[]) {
        people.generatePeople();
//        System.out.println(people.printPeopleList());
//        people.sortPeopleByAge();
        people.sortPeopleAlphabetical();
    }

    private void generatePeople() {
        peopleList.add(new Person("Ricardo", 27, "Portugal"));
        peopleList.add(new Person("Adriana", 29, "Italy"));
        peopleList.add(new Person("Pedro", 25, "Portugal"));
        peopleList.add(new Person("Diogo", 30, "Portugal"));
        peopleList.add(new Person("Rafael", 23, "England"));
        peopleList.add(new Person("Igor", 28, "Portugal"));
        peopleList.add(new Person("Andre", 10, "Portugal"));
        peopleList.add(new Person("Renato", 16, "Portugal"));
        peopleList.add(new Person("Francisco", 17, "Portugal"));
        peopleList.add(new Person("Mafalda", 28, "Portugal"));
        peopleList.add(new Person("Joao", 35, "Portugal"));
        peopleList.add(new Person("Antonio", 41, "Portugal"));
        peopleList.add(new Person("Maria", 42, "Portugal"));
        peopleList.add(new Person("Dinarte", 53, "Portugal"));
        peopleList.add(new Person("Rui", 45, "Portugal"));
        peopleList.add(new Person("Paulo", 8, "Portugal"));
        peopleList.add(new Person("Freitas", 5, "Portugal"));
        peopleList.add(new Person("Hugo", 32, "Portugal"));
        peopleList.add(new Person("Marco", 22, "Portugal"));
        peopleList.add(new Person("Jose", 11, "Portugal"));
    }

    private List<Person> printPeopleList() {
        return peopleList;
    }

    private void sortPeopleByAge() {
        List<Person> tempList = peopleList;

        for(int i = 0; i < peopleList.size(); i++) {
            for(int j = i; j < peopleList.size(); j++) {
                if(tempList.get(j).getAge() < tempList.get(i).getAge()) {
                    tempList.add(i, tempList.get(j));
                    tempList.remove(j+1);
                }
            }
        }

        printSortedList(tempList);
    }

    private void sortPeopleAlphabetical() {
        List<Person> tempList = peopleList;

        for(int i = 0; i < peopleList.size(); i++) {
            for(int j = i; j < peopleList.size(); j++) {
                if(tempList.get(j).getName().toLowerCase().charAt(0) < tempList.get(i).getName().toLowerCase().charAt(0)) {
                    tempList.add(i, tempList.get(j));
                    tempList.remove(j+1);
                }
            }
        }

        printSortedList(tempList);
    }

    private void printSortedList(List<Person> list) {
        for(Person person:list) {
            System.out.println(person.getName() + ", " + person.getAge() + ", from " + person.getCountry());
        }
    }

}
