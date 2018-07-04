package org.wuliu.entity;

import java.util.Date;


public class Knowledge {

    private int id;
    private String title;
    private String content;
    private String author;
    private Date issueDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Knowledge(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Knowledge(String title, String content,int id) {
        this.title = title;
        this.content = content;
        this.id=id;
    }

    public Knowledge() {

    }
}
