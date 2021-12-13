package com.example.projectandroidtest;

import java.util.ArrayList;

public class Message {
    protected String uid;
    protected User user1;
    protected User user2;
    protected ArrayList<String> message1;
    protected ArrayList<String> message2;

    public String getUid() {return uid;}
    public void setUid(String uid) {this.uid = uid;}
    public User getUser1() {return user1;}
    public void setUser1(User user1) {this.user1 = user1;}
    public User getUser2() {return user2;}
    public void setUser2(User user2) {this.user2 = user2;}
    public ArrayList<String> getMessage1() {return message1;}
    public void setMessage1(ArrayList<String> message1) {this.message1 = message1;}
    public ArrayList<String> getMessage2() {return message2;}
    public void setMessage2(ArrayList<String> message2) {this.message2 = message2;}
}
