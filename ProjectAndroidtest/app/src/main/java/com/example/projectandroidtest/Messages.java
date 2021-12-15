package com.example.projectandroidtest;

import android.util.Log;

import java.util.ArrayList;

public class Messages {
    protected String uid;
    protected User user1;
    protected User user2;
    protected ArrayList<Message> message = new ArrayList<Message>();

    public String getUid() {return uid;}
    public void setUid(String uid) {this.uid = uid;}
    public User getUser1() {return user1;}
    public void setUser1(User user1) {this.user1 = user1;}
    public User getUser2() {return user2;}
    public void setUser2(User user2) {this.user2 = user2;}

    public ArrayList<Message> getMessage() {return message;}
    public void setMessage(ArrayList<Message> message1) {this.message = message1;}
    public void addMessage1(String text){this.message.add(new Message(user1,text));}
    public void addMessage2(String text){this.message.add(new Message(user2,text));}
    public void addMessage(Message message){this.message.add(message);}
    public Messages(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
    public Messages(){

    }

    @Override
    public String toString() {
        return "Message{" +
                "uid='" + uid + '\'' +
                ", user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }

    public String checknom(User user){
        if (user.compare(user1)){
            return user2.getNom();
        }
        else{
            return user1.getNom();
        }
    }

    public String checklast(User user){
        if (user.compare(user1)){
            int i = message.size()-1;
            while(message.get(i).getUser().compare(user)){
                if (message.get(i).getUser().compare(user)){
                    return message.get(i).getMessage();

                }
                i--;
            }

        }
        return null;

    }


}
