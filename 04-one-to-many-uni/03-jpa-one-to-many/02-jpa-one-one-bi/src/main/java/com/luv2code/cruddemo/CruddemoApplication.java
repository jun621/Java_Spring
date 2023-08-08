package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	 @Bean
	public CommandLineRunner commandlinerunner(AppDAO appDao) {
		// java lambda expression
		return runner -> {

			//findcourseandStudents(appDao);

			//findStudentsandCourse(appDao);

			addCoursestoStudent(appDao) ;

			deleteCourse(appDao);
		};

	}

	private void addCoursestoStudent(AppDAO appDao) {
		Student tempStudent = new Student ("Junichi", "Koizumi", "jkoizum1@asu.edu");
		Course course1 = new Course("Principles of Programming Language");
		Course course2 = new Course("Distributed Software Development");
		Course course3 = new Course ("Intro Human Computer Interaction");
		Course course4 = new Course (" Found of Machine Learning");

		tempStudent.addCourses(course1);
		tempStudent.addCourses(course2);
		tempStudent.addCourses(course3);
		tempStudent.addCourses(course4);

		appDao.Save(tempStudent);
		System.out.println("Added Courses to Student");

	}

	private void findStudentsandCourse(AppDAO appDao) {
		int theId = 5;
		Student tempStudents = appDao.findStudentByStudentId(theId);
		System.out.println("Found Student with the Id" + tempStudents);
		System.out.println("Found classes associated with student" + tempStudents.getCourses());

	}

	private void findcourseandStudents(AppDAO appDao) {
		int theId = 10 ;

		Course course = appDao.findCourseandstudentbyCourseId(theId);
		System.out.println("Found course with corresponding student" + course);
		System.out.println("Found student with course " + course.getStudent());

	}

	private void createCourseandStudents(AppDAO appDao) {
		Course theCourse = new Course("principles to programming");
		Student theStudent = new Student ("john ","Jones","Jones@gmail.com");

		theCourse.addStudent(theStudent);
		appDao.Save(theCourse);
	}

	private void deletCourseandReviews(AppDAO appDao) {
		int tempID = 1 ;
		appDao.DeleteCourse(tempID);


	}

	private void retrieveCourseandReviews(AppDAO appDao) {

		// get Course and reviews
		int theID = 1 ;
		Course tempCourse = appDao.findCourseandReviewsbyId(theID);

		// print the course
		System.out.println("Courses: " + tempCourse);
		System.out.println("the reviews " + tempCourse.getReviews());

	}

	private void saveCourse(AppDAO appDao) {
        // create a course
		Course courses  = new Course("Sekiro how to not die twice ");

		// add some reviews
		courses.addreview(new review("Impossible"));
		courses.addreview(new review("Totally doable !!!"));
		courses.addreview(new review("Insanity"));
		courses.addreview(new review("Copium"));

		System.out.println("adding reviews" + courses );
		System.out.println(courses.getReviews());
		// save the course
		//appDao.Save(courses);
		DeleteStudent(appDao);



	}

	private void DeleteStudent(AppDAO appDao) {
		int theId =5;
		appDao.DeleteStudentById(theId);
	}

	private void deleteCourse(AppDAO appDao) {
		int theId = 1;
		appDao.DeleteCourse(theId);
		System.out.println("Course is deleted!!!");
	}


	private void UpdateCourse(AppDAO appDao) {
	  int theId = 1;
	  Course tempcourse = appDao.findCourseById(theId);
	  tempcourse.setTitle("Enjoy the things that suck");
	  appDao.Update(tempcourse);
	  System.out.println("Successfully updated the course");

	}

	private void UpdateInstructor(AppDAO appDao) {
		int theId = 1;
		Instructor tempInstructor = appDao.findInstructorById(theId);
		tempInstructor.setLastName("TESTER");
		appDao.Update(tempInstructor);

	}


	private void findInstructorWithCOurseJoinFetch(AppDAO appDao) {
		int theId = 1 ;
		Instructor tempInstructor = appDao.findInstructorByIdjoinFetch(theId);
		System.out.println("Instructor found"+ tempInstructor) ;
		System.out.println("the associated courses" + tempInstructor.getCourses());

	}

	private void findCoursesforInstructor(AppDAO appDao) {

		int theId = 1;
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("Done"+ tempInstructor.getCourses());

		// find courses for instructor
		System.out.println("Finding courses for" + theId);
		List<Course> courses = appDao.findCoursesByInstructorId(theId);


	}

	private void findInstructorwithCourses(AppDAO appDao) {
		int theId = 1;
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("Done"+ tempInstructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDao) {
		Instructor tempInstructor = new Instructor("Hanma", "Yuichiro" ,"Ogre@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "fighting");
		tempInstructor.setInstructordetail(tempInstructorDetail);
		// create some courses
		Course tempcourse1 = new Course("Air Yashoku - theUltimateGuide");
		Course tempcourse2 = new Course("Isekai Tensei Kamawan -theUltimateGuide");

		tempInstructor.add(tempcourse1);
		tempInstructor.add(tempcourse2);
		appDao.Save(tempInstructor);
		System.out.println("Courses saved !!!!") ;


	}

	private void deleteInstructordetail(AppDAO appDao) {
		int theId = 2;
		appDao.DeleteInstructordetailById(theId);

	}

	private void findInstructorDetail(AppDAO appDao) {
		int theId = 1;
		InstructorDetail tempInstructor  = appDao.findInstructorDetailById(theId);
		System.out.println("Looking for instructor detail :" + tempInstructor);
		System.out.println("the associated instructor " + tempInstructor.getInstructor());
	}

	private void deleteInstructor(AppDAO appDao) {

		int theId = 1 ;
		System.out.println("Looking for Instructor" + theId) ;
		appDao.DeleteById(theId);
		System.out.println("Deleted Instructor ID:" + theId);


	}

	private void findInstructor(AppDAO appDao) {

		int theId =1 ;
		System.out.println("Finding instructor Id..." + theId);
		Instructor tempInstructor = appDao.findInstructorById(theId) ;
		System.out.println("tempInstructor: " + tempInstructor.getInstructordetail());
	}

	private void createInstructor(AppDAO appDao) {

		/*

		Instructor tempInstructor = new Instructor("Chad", "Darby" ,"darby@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv2code");

		*/
		Instructor tempInstructor = new Instructor("Chad", "Darby" ,"darby@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv2code");
		tempInstructor.setInstructordetail(tempInstructorDetail);

		System.out.println("Saving Instructor" + tempInstructor);
		appDao.Save(tempInstructor);

			System.out.println("Done");
	}

}
