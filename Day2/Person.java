package Day2;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 30);

        System.out.println(p1.name + " "  + p1.age);
        System.out.println(p2.name + " "  + p2.age);
    }

}
