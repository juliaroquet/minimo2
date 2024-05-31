package edu.upc.dsa.models;

public class Question {

    private String date;
    private String title;
    private String message;
    private String sender;

    private int questionId;

    public Question() {
    }

    public Question(String date, String title, String message, String sender) {
        this.date = date;
        this.title = title;
        this.message = message;
        this.sender = sender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    public int getQuestionId() {

        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

}
