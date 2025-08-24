public class Demo04 {
    public static void main(String[] args) {
        //payment processors
        PaymentProcessor cardProcessor = new CardPaymentProcessor();
        PaymentProcessor upiProcessor = new UPIPaymentProcessor();
        PaymentProcessor walletProcessor = new WalletPaymentProcessor();
        
        //service with processor registry
        PaymentService paymentService = new PaymentService();
        paymentService.registerProcessor("CARD", cardProcessor);
        paymentService.registerProcessor("UPI", upiProcessor);
        paymentService.registerProcessor("WALLET", walletProcessor);
        
        //functionality demo
        System.out.println("----Payment Service Demo----");
        System.out.println(paymentService.pay(new Payment("UPI", 499)));
        
        // Additional tests
        System.out.println(paymentService.pay(new Payment("CARD", 299)));
        System.out.println(paymentService.pay(new Payment("WALLET", 150)));
    }
}