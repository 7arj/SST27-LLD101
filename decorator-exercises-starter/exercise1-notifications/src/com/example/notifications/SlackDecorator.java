package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {
    private String channel;
    
    public SlackDecorator(Notifier notifier, String channel) {
        super(notifier);
        this.channel = channel;
    }
    
    @Override
    public void notify(String text) {
        sendSlackMessage(text);
        super.notify(text); // Delegate to wrapped notifier
    }
    
    private void sendSlackMessage(String text) {
        System.out.println("Slack message to #" + channel + ": " + text);
    }
}