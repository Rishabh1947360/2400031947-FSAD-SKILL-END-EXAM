package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {
    @Id @GeneratedValue
    private int id;
    private String name, status;
    private Date date;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }
    public Date getDate() { return date; }

    public void setName(String n){name=n;}
    public void setStatus(String s){status=s;}
    public void setDate(Date d){date=d;}
}