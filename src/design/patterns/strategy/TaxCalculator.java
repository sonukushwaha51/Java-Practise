package design.patterns.strategy;

public interface TaxCalculator {

    double calculateTax(double amount);
}

class IndiaTaxCalculator implements TaxCalculator {

    @Override
    public double calculateTax(double amount) {
        return amount * 1.20;
    }
}

class USTaxCalculator implements TaxCalculator {

    @Override
    public double calculateTax(double amount) {
        return amount * 1.05;
    }
}

class AmountAfterTax {

    private static TaxCalculator taxCalculator = new IndiaTaxCalculator();
    public static void main(String[] args) {
        taxCalculator = new USTaxCalculator();
        double totalAmount = taxCalculator.calculateTax(1873817.13);
        System.out.println(totalAmount);

    }
}
