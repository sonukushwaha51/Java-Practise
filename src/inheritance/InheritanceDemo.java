package inheritance;

public class InheritanceDemo {

    public static void main(String[] args) {

    }
}

class Animal {

    public String getAnimal() {
        return "Generic animal";
    }

    public Animal animal() {
        return new Animal();
    }
}

class Lion extends Animal {


    // This override works because return type and number of parameters are same
    @Override
    public String getAnimal() {
        return "Lion";
    }

    // This won't work because method parameters are different.
//    @Override
//    public String getAnimal(String animal) {
//        return animal;
//    }

    // This override is allowed as we are overriding with child class
    @Override
    public Lion animal() {
        return new Lion();
    }


}
