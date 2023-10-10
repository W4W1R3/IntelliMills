package com.example.intellimills;

public class MessagingClass {
    private String name;
    private String email;
    private String report;

    // Default constructor (required for Firebase)
    public MessagingClass() {
        // Default constructor required for calls to DataSnapshot.getValue(MessagingClass.class)
    }

    public MessagingClass(String name, String email, String report) {
        this.name = name;
        this.email = email;
        this.report = report;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
