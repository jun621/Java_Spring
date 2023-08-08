package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name ="Course")
public class Course {


    public Course (String title) {

        this.title = title;

    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id" )
    private List <review> reviews ;

    public List<review> getReviews() {
        return reviews;
    }

    public void setReviews(List<review> reviews) {
        this.reviews = reviews;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH
    ,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor  theInstructor;

    @ManyToMany(fetch = FetchType.LAZY,cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH
            ,CascadeType.REFRESH})
    private List<Student> student;

    @JoinTable(name= "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns  = @JoinColumn(name ="student_id")

    )


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

    public Instructor getTheInstructor() {
        return theInstructor;
    }

    public void setTheInstructor(Instructor theInstructor) {
        this.theInstructor = theInstructor;
    }

    // add a convenience method
    public void addreview (review theReview) {

        if (reviews == null) {

            reviews = new ArrayList<>();
        }
        reviews.add(theReview);
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;

    }

    public void addStudent (Student tempstudent) {

        // if student list is empty create list
        if (student == null) {

            student = new ArrayList<>();
        }
        student.add(tempstudent);
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
