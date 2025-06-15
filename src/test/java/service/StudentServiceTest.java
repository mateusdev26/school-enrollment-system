package service;

import domain.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Log4j2
class StudentServiceTest {
    @Test
    public void ShouldNotThrowsSQLExceptionInSave()  {
        Student tony = Student.builder().age(12).name("Tony").mark(30f).grade("5th grade").build();
        assertDoesNotThrow(() -> StudentService.save(tony), "Didn't threw a SQLException");
    }

    @Test
    public void ShouldNotThrowsSQLExceptionInFindAll() throws SQLException {
        assertDoesNotThrow(()->StudentService.findAll(), "Didn't threw a SQLException");
       StudentService.findAll().forEach(log::info);
    }

    @Test
    public void ShouldNotThrowsSQLExceptionInDelete() {
        assertDoesNotThrow(() -> StudentService.delete(63,64,65), "Didn't threw a SQLException");
    }
   @Test
   public void ShouldNotThrowsSQLExceptionInFindById(){
        final int id = 8 ;
       assertDoesNotThrow(()->StudentService.findById(id),"Didn't threw a SQLException");
   }
   @Test
    public void ShouldNotThrowsSQLExceptionInUpdate(){
       final Student maria = Student.builder().name("Maria").age(12).grade("5th grade").mark(30f).build();
       final int id = 20 ;
       assertDoesNotThrow(()->StudentService.update(maria,id),"Didn't threw a SQLException");
   }


}