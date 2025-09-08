package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
    private String phoneNumber;
    
    public SmsDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void notify(String text) {
        sendSms(text);
        super.notify(text); //delegate to wrapped notifier
    }
    
    private void sendSms(String text) {
        System.out.println("SMS sent to " + phoneNumber + ": " + text);
    }
}