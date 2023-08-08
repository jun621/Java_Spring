package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void Save (Instructor theInstructor) ;

    Instructor findInstructorById(int theId);

    void DeleteById(int theId);

    InstructorDetail findInstructorDetailById(int theId) ;

    void DeleteInstructordetailById(int theId);

    List<Course> findCoursesByInstructorId (int theId);

    Instructor findInstructorByIdjoinFetch (int theId);

    void Update (Instructor tempInstructor);

    void Update(Course course);

    Course findCourseById(int theId);

    void DeleteCourse(int theId);

    void Save (Course theCourse);

    Course findCourseandReviewsbyId (int theID);

    Course findCourseandstudentbyCourseId(int theId);

    Student findStudentByStudentId(int theId);

    void Save (Student theStudents) ;


    void DeleteStudentById(int theId);




}
