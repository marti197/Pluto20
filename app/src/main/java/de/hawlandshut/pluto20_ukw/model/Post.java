package de.hawlandshut.pluto20_ukw.model;

public class Post {
    public String uid;
    public String author;
    public String title;
    public String body;
    public long timestamp;
    public String firebaseKey;


    public Post(String uid, String author, String title, String body, long timestamp, String firebaseKey) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
        this.timestamp = timestamp;
        this.firebaseKey = firebaseKey;
    }
}
