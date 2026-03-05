package design.patterns.builder;

public class Customer {

    private String name;

    private int age;

    private Customer() {

    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    static class Builder {

        private String name;

        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Customer build() {
            return new Customer(name, age);
        }

    }
}

class CustomerMain {
    public static void main(String[] args) {
        Customer customer = Customer.Builder.newBuilder()
                .name("Sonu")
                .age(26)
                .build();
        System.out.println(customer.getName() + customer.getAge());

    }
}