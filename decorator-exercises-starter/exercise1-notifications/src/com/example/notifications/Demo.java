package com.example.notifications;

public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");
        
        System.out.println("--- Baseline email only ---");
        base.notify("Baseline email only.");
        
        System.out.println("\n--- Email + SMS ---");
        Notifier smsAndEmail = new SmsDecorator(base, "+91-99999-11111");
        smsAndEmail.notify("Build green");
        
        System.out.println("\n--- Email + WhatsApp ---");
        Notifier whatsappAndEmail = new WhatsAppDecorator(base, "user_wa");
        whatsappAndEmail.notify("Code review completed");
        
        System.out.println("\n--- Email + Slack ---");
        Notifier slackAndEmail = new SlackDecorator(base, "deployments");
        slackAndEmail.notify("Deployment started");
        
        System.out.println("\n--- Email + WhatsApp + Slack ---");
        Notifier multiChannel = new SlackDecorator(
            new WhatsAppDecorator(base, "user_wa"), 
            "deployments"
        );
        multiChannel.notify("Deployment completed");
    }
}