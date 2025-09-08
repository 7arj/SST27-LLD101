package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private String whatsappId;
    
    public WhatsAppDecorator(Notifier notifier, String whatsappId) {
        super(notifier);
        this.whatsappId = whatsappId;
    }
    
    @Override
    public void notify(String text) {
        sendWhatsApp(text);
        super.notify(text); //Delegate to wrapped notifier
    }
    
    private void sendWhatsApp(String text) {
        System.out.println("WhatsApp message to @" + whatsappId + ": " + text);
    }
}