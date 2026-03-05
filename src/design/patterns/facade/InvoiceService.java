package design.patterns.facade;

public class InvoiceService {

    public String generateInvoice() {
        return "Invoice generated";
    }

}

class PaymentService {

    public String fulfillPayment() {
        return "Payment completed";
    }
}

class FacadeDemo {

    private final InvoiceService invoiceService;

    private final PaymentService paymentService;

    FacadeDemo(InvoiceService invoiceService, PaymentService paymentService) {
        this.invoiceService = invoiceService;
        this.paymentService = paymentService;
    }

    public static void main(String[] args) {

        FacadeDemo facadeDemo = new FacadeDemo(new InvoiceService(), new PaymentService());
        String generateInvoice = facadeDemo.invoiceService.generateInvoice();
        System.out.println(generateInvoice);

        String payment = facadeDemo.paymentService.fulfillPayment();
        System.out.println(payment);

    }
}

