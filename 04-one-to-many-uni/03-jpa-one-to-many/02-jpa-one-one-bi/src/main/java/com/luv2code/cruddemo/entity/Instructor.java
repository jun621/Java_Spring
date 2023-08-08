package com.luv2code.cruddemo.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "instructor")
public class Instructor {


    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<Course> courses ;




   public Instructor () {

   }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Id
   @Column(name = "id")
   private int id;

   @Column(name="firstName")
   private String firstName;

   @Column(name= "lastName")
   private String lastName;

   @Column(name = "email")
   private String email ;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="instructor_detail_id")
   private InstructorDetail instructordetail ;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructordetail() {
        return instructordetail;
    }

    public void setInstructordetail(InstructorDetail instructordetail) {
        this.instructordetail = instructordetail;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructordetail=" + instructordetail +
                '}';
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    // add convenience methods for bi-directional relationship

    public void add (Course course) {

        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);

        course.setTheInstructor(this);
    }
}
