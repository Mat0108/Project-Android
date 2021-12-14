package com.example.projectandroidtest;

import android.util.Log;

import java.util.ArrayList;

public class Message {
    protected String uid;
    protected User user1;
    protected User user2;
    protected ArrayList<String> message1 = new ArrayList<String>();
    protected ArrayList<String> message2 = new ArrayList<String>();

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
    public void addMessage1(String message){this.message1.add(message);}
    public void addMessage2(String message){this.message2.add(message);}
    public Message(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
    public Message(){

    }

    @Override
    public String toString() {
        return "Message{" +
                "uid='" + uid + '\'' +
                ", user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }
    public void checkmessage(User user,String[] mDataset){
        if (user.compare(user1)){
            for(int i=0;i<message1.size();i++){
                mDataset[i*2]=message1.get(i);
                mDataset[i*2+1] = message2.get(i);
            }
        }
        if (user.compare(user2)){

            for(int i=0;i<message1.size();i++){
                mDataset[i*2]=message2.get(i);
                mDataset[i*2+1] = message1.get(i);
            }
        }
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
            return message2.get(message2.size()-1);
        }
        if (user.compare(user2)){


            return message1.get(message1.size()-1);
        }
        return null;
    }

}
