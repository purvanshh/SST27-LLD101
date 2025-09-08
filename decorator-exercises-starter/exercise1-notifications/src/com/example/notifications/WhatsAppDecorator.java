package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String waId;

    public WhatsAppDecorator(Notifier wrapped, String waId) {
        super(wrapped);
        this.waId = waId;
    }

    @Override
    public void notify(String text) {
        System.out.println("[WhatsApp -> " + waId + "]: " + text);
        super.notify(text);
    }
}
