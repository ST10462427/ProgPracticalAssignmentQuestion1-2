package ArrayCode1;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentManagementApplicationTest extends StudentManagementApplication {

    @Test
    public void TestSaveStudent() {
        StudentManagementApplication app = new StudentManagementApplication();
        Student student = new Student(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        app.captureStudent(student);
        assertEquals(student, app.getStudent(10111));
    }

    @Test
    public void TestSearchStudent() {
        StudentManagementApplication app = new StudentManagementApplication();
        Student student = new Student(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        app.captureStudent(student);
        Student foundStudent = app.searchStudent(10111);
        assertEquals(student, foundStudent);
    }

    @Test
    public void TestSearchStudent_StudentNotFound() {
        StudentManagementApplication app = new StudentManagementApplication();
        Student foundStudent = app.searchStudent(10111);
        assertNull(foundStudent);
    }

    @Test
    public void TestDeleteStudent() {
        StudentManagementApplication app = new StudentManagementApplication();
        Student student = new Student(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        app.captureStudent(student);
        app.deleteStudent(10111);
        Student foundStudent = app.searchStudent(10111);
        assertNull(foundStudent);
    }

    @Test
    public void TestDeleteStudent_StudentNotFound() {
        StudentManagementApplication app = new StudentManagementApplication();
        app.deleteStudent(10111);
        Student foundStudent = app.searchStudent(10111);
        assertNull(foundStudent);
    }
}


