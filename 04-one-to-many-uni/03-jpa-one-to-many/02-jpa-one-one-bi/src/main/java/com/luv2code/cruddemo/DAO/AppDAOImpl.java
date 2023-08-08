package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{


 private EntityManager entityManager;



 // function injection
 @Autowired
 public AppDAOImpl (EntityManager theEntityManager){
            entityManager = theEntityManager;

 }

    @Override
    @Transactional
    public void Save(Instructor theInstructor) {

        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {

     return entityManager.find(Instructor.class, theId);


    }

    @Override
    public void DeleteById(int theId) {

     Instructor tempInstructor = entityManager.find(Instructor.class, theId);
     entityManager.remove(theId);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

    return  entityManager.find(InstructorDetail.class, theId);

    }

    @Override
    public void DeleteInstructordetailById(int theId) {

     InstructorDetail tempInstructor = entityManager.find(InstructorDetail.class, theId);

     List <Course> courses  = tempInstructor.getInstructor().getCourses();


     for (Course tempcourses : courses) {
        tempcourses.setTheInstructor(null);
     }

       entityManager.remove(tempInstructor);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor = :date" ,
                Course.class ) ;

         query.setParameter("data", theId);

         List <Course> courses = query.getResultList();
         return courses ;
    }

    @Override
    public Instructor findInstructorByIdjoinFetch(int theId) {
       TypedQuery <Instructor> query = entityManager.createQuery(
               "select i from Instructor i" +
                       " JOIN FETCH i.courses " +
                       " where i.id = :data" , Instructor.class);
       query.setParameter("data", theId);

       // execute
       Instructor instructor = query.getSingleResult();

       return instructor ;

    }

    @Override
    public void Update(Instructor tempInstructor) {
     // update the instructor
     entityManager.merge(tempInstructor);


    }

    @Transactional
    @Override
    public void Update(Course course) {
     //update the course
     entityManager.merge(course);

    }

    @Override
    public Course findCourseById(int theId) {
      return   entityManager.find(Course.class, theId);
    }

    @Override
    public void DeleteCourse(int theId) {
        Course tempcourse = entityManager.find(Course.class,theId);
        entityManager.remove(tempcourse);
        System.out.println("Course Deleted ");
    }


    // add more students to course
    @Override
    @Transactional
    public void Save(Course theCourse) {

    entityManager.persist(theCourse);

    }

    @Override
    public Course findCourseandReviewsbyId(int theID) {

       TypedQuery<Course> query = entityManager.createQuery(
               "select c from Course c"
               + "Join FETCH c.reviews "
               + "where c.id = :data" ,Course.class
               ) ;


            query.setParameter("data", theID);

            Course courses = query.getSingleResult();

            return courses;
    }

    @Override
    public Course findCourseandstudentbyCourseId(int theId) {

       // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c"
                        + "Join FETCH c.students "
                        + "where c.id = :data" ,Course.class
        ) ;


        query.setParameter("data", theId);
        // execute query
        Course courses = query.getSingleResult();

        return courses;
    }

    @Override
    public Student findStudentByStudentId(int theId) {

        // create query
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s"
                        + "Join FETCH s.students "
                        + "where s.id = :data" ,
                Student.class
        ) ;


        query.setParameter("data", theId);
        // execute query
        Student students = query.getSingleResult();

        return students;

    }

    // add more courses to student
    @Transactional
    @Override
    public void Save(Student theStudents) {
        entityManager.persist(theStudents);
    }

    @Override
    @Transactional
    public void DeleteStudentById(int theId) {
        Student tempStudent =  entityManager.find(Student.class,theId);
        entityManager.remove(tempStudent);


    }


}
