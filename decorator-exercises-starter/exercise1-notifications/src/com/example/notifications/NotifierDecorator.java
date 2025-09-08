package com.example.notifications;

/**
 * Base decorator that forwards to a wrapped Notifier.
 */
public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrapped;

    public NotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void notify(String text) {
        // Default behavior: delegate to wrapped notifier
        wrapped.notify(text);
    }
}
