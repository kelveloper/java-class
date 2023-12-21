package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoStubImpl;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ClassRosterServiceLayerImplTest {
    private ClassRosterServiceLayer service;

    public ClassRosterServiceLayerImplTest() {
        // wire the Service Layer with stub implementations of the Dao and
        // Audit Dao
        // ClassRosterDao dao = new ClassRosterDaoStubImpl();
        // ClassRosterAuditDao auditDao =
        //           new ClassRosterAuditDaoStubImpl();
        //
        // service = new ClassRosterServiceLayerImpl(dao, auditDao);

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        service =
                ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
    }

    @Test
    public void testCreateValidStudent() {
        // ARRANGE
        Student student = new Student("0002");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");
        // ACT
        try {
            service.createStudent(student);
        } catch (ClassRosterDuplicateIdException
                 | ClassRosterDataValidationException
                 | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Student was valid. No exception should have been thrown.");
        }
    }
    @Test
    public void testCreateDuplicateIdStudent() {
        // ARRANGE
        Student student = new Student("0001");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        // ACT
        try {
            service.createStudent(student);
            fail("Expected DupeId Exception was not thrown.");
        } catch (ClassRosterDataValidationException
                 | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (ClassRosterDuplicateIdException e){
            return;
        }
    }

    @Test
    public void testCreateStudentInvalidData() throws Exception {
        // ARRANGE
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        // ACT
        try {
            service.createStudent(student);
            fail("Expected ValidationException was not thrown.");
        } catch (ClassRosterDuplicateIdException
                 | ClassRosterPersistenceException e) {
            // ASSERT
            fail("Incorrect exception was thrown.");
        } catch (ClassRosterDataValidationException e){
            return;
        }
    }

    @Test
    public void testGetAllStudents() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT & ASSERT
        assertEquals( 1, service.getAllStudents().size(),
                "Should only have one student.");
        assertTrue( service.getAllStudents().contains(testClone),
                "The one student should be Ada.");
    }

    @Test
    public void testGetStudent() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT & ASSERT
        Student shouldBeAda = service.getStudent("0001");
        assertNotNull(shouldBeAda, "Getting 0001 should be not null.");
        assertEquals( testClone, shouldBeAda,
                "Student stored under 0001 should be Ada.");

        Student shouldBeNull = service.getStudent("0042");
        assertNull( shouldBeNull, "Getting 0042 should be null.");

    }

    @Test
    public void testRemoveStudent() throws Exception {
        // ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        // ACT & ASSERT
        Student shouldBeAda = service.removeStudent("0001");
        assertNotNull( shouldBeAda, "Removing 0001 should be not null.");
        assertEquals( testClone, shouldBeAda, "Student removed from 0001 should be Ada.");

        Student shouldBeNull = service.removeStudent("0042");
        assertNull( shouldBeNull, "Removing 0042 should be null.");

    }
}