package com.example.projectandroidtest;

public class Message {
    private User user;
    private String message;

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public Message(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public Message() {

    }

    @Override
    public String toString() {
        return "Message{" +
                "user" + user.toString() +
                ", message='" + message + '\'' +
                '}';
    }
}
