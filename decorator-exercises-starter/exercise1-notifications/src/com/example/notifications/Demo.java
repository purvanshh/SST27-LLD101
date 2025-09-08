package com.example.notifications;

public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");

        System.out.println("\n--- Compositions ---");

        // a) Email + SMS
        Notifier emailPlusSms = new SmsDecorator(base, "+91-99999-11111");
        emailPlusSms.notify("Email + SMS: Build green ✅");

        // b) Email + WhatsApp
        Notifier emailPlusWa = new WhatsAppDecorator(base, "user_wa");
        emailPlusWa.notify("Email + WhatsApp: New message");

        // c) Email + Slack
        Notifier emailPlusSlack = new SlackDecorator(base, "general");
        emailPlusSlack.notify("Email + Slack: Standup in 5");

        // d) Email + WhatsApp + Slack (stacked)
        Notifier full = new SlackDecorator(new WhatsAppDecorator(base, "user_wa"), "deployments");
        full.notify("Email + WhatsApp + Slack: Deployment completed 🚀");
    }
}
