package service;

import domain.Student;
import lombok.extern.log4j.Log4j2;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.List;

@Log4j2
public final class StudentService {
    private static void LogIdCantBe0orNegative() {
        log.info("Id can't be 0 or negative");
    }
    public static int save(Student student,boolean Log) throws SQLException {
        if (student == null) {
            log.info("Student can't be null");
            return 0;
        } else {
            return new StudentRepository() {
            }.save(student,Log);
        }
    }

    public static Student findById(int id ,boolean Log) throws SQLException{
        if (is0orNegative(id)) {
           if(Log) LogIdCantBe0orNegative();
            return null;
        } else {
            return new StudentRepository() {
            }.findById(id);
        }
    }

    public static List<Student> findAll(boolean Log) throws SQLException{
        if (new StudentRepository() {
        }.findAll().isEmpty()) {
            if (Log)log.info("Students not found");
        } else {
            return new StudentRepository() {
            }.findAll();
        }
        return List.of();
    }
    public static List<Student> findAll() throws SQLException{
        if (new StudentRepository() {
        }.findAll().isEmpty()) {
            log.info("Students not found");
        } else {
            return new StudentRepository() {
            }.findAll();
        }
        return List.of();
    }

    public static int update(Student student, int id,boolean Log) throws SQLException{
        if(is0orNegative(id)){
           LogIdCantBe0orNegative();
            return 0 ;
        }else{
        return new StudentRepository() {
        }.update(student, id,Log);
    }}

    private static boolean is0orNegative(int id) {
        return id <= 0;
    }



    public static int delete(int id,boolean Log) throws SQLException{
        if (is0orNegative(id)) {
            LogIdCantBe0orNegative();
            return 0;
        } else {
            return new StudentRepository() {
            }.delete(id,Log);
        }

    }



    public static int delete(boolean Log, int... ids) throws SQLException{
        if (ids.length == 0) {
            log.info("Ids can't be empty");
            return 0 ;
        } else {
            return new StudentRepository() {
            }.delete(Log,ids);

        }
    }
    public static int save(Student student) throws SQLException {
        if (student == null) {
            log.info("Student can't be null");
            return 0;
        } else {
            return new StudentRepository() {
            }.save(student,true);
        }
    }

    public static Student findById(int id) throws SQLException{
        if (is0orNegative(id)) {
            LogIdCantBe0orNegative();
            return null;
        } else {
            return new StudentRepository() {
            }.findById(id);
        }
    }


    public static int update(Student student, int id) throws SQLException{
        if(is0orNegative(id)){
            LogIdCantBe0orNegative();
            return 0 ;
        }else{
            return new StudentRepository() {
            }.update(student, id,true);
        }}




    public static int delete(int id) throws SQLException{
        if (is0orNegative(id)) {
            LogIdCantBe0orNegative();
            return 0;
        } else {
            return new StudentRepository() {
            }.delete(id,true);
        }

    }



    public static int delete(int... ids) throws SQLException{
        if (ids.length == 0) {
            log.info("Ids can't be empty");
            return 0 ;
        } else {
            return new StudentRepository() {
            }.delete(true,ids);

        }
    }


}


