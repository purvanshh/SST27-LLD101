package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
    private final String phone;

    public SmsDecorator(Notifier wrapped, String phone) {
        super(wrapped);
        this.phone = phone;
    }

    @Override
    public void notify(String text) {
        // Simulate sending SMS
        System.out.println("[SMS -> " + phone + "]: " + text);
        super.notify(text);
    }
}
