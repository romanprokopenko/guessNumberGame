package ua.training.prototype;

/**
 * Created by Roman on 28.11.2016.
 */
public class PrototypePattern {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Human original = new Human(18, "Vasya");
        Human copy = original.copy();
        System.out.println(copy);
        System.out.println(original);

        HumanFactory factory = new HumanFactory(copy);
        Human human1 = factory.makeCopy();
        System.out.println(human1);

        factory.setPrototype(new Human(30, "Valerya"));
        Human human2 = factory.makeCopy();
        System.out.println(human2);
    }

}

interface Copyable<E> {
    E copy();
}

class Human implements Copyable<Human> {
    int age;
    String name;

    @Override
    public String toString() {
        return "Human [age=" + age + ", name=" + name + "]";
    }

    public Human(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    @Override
    public Human copy() {
        // TODO Auto-generated method stub
        Human copy = new Human(age, name);
        return copy;
    }
}

class HumanFactory {
    Human human;

    public HumanFactory(Human human) {
        setPrototype(human);
    }

    public void setPrototype(Human human) {
        this.human = human;
    }

    public Human makeCopy() {
        return  human.copy();
    }
}

