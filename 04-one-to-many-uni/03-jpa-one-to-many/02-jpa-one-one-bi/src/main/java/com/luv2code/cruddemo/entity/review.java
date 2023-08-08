package com.luv2code.cruddemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="review")
public class review {

   // define fields
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id ;

    @Column(name ="comment")
    private String comment;

    // define constructors

    public review(String comment) {
        this.comment = comment;
    }

    // define getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
