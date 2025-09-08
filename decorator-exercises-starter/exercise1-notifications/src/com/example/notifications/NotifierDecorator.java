package com.example.notifications;

import java.util.Objects;

public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;
    
    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = Objects.requireNonNull(notifier, "Notifier cannot be null");
    }
    
    @Override
    public void notify(String text) {
        wrappedNotifier.notify(text);
    }
}
