package repository;

import conn.ConnectionFactory;
import domain.Student;
import interfaces.Repository;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public abstract class StudentRepository implements Repository<Student> {
    public int save(Student student,boolean log) {
        int rows = 0;
        String sql = "INSERT INTO `school`.`student` (`name`, `age`, `grade`, `mark`) VALUES (?, ?, ?, ?);";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getGrade());
            pstmt.setFloat(4, student.getMark());
            rows = pstmt.executeUpdate();
           if(log)LogRowsAffected(rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public Student findById(int id) {
        Student output = null;
        String query = "SELECT * FROM student WHERE id = " + id + ";";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                output = Student.builder()
                        .id(id)
                        .name(rs.getString(1))
                        .age(rs.getInt(2))
                        .grade(rs.getString(3))
                        .mark(rs.getFloat(4))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    public List<Student> findAll() {
        List<Student> output = new ArrayList<>();
        String query = "SELECT * FROM student;";
        try (Connection conn = ConnectionFactory.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(query)) {
            while (rs.next()) {
                Student rsOutput = Student.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .age(rs.getInt("age"))
                        .grade(rs.getString("grade"))
                        .mark(rs.getFloat("mark"))
                        .build();
                output.add(rsOutput);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    public int update(Student student, int id,boolean log) {
        int rows = 0;
        String sql = "UPDATE student SET name = ?, age = ?, grade = ?, mark = ? WHERE id = "+id;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1,student.getName());
             pstmt.setInt(2,student.getAge());
             pstmt.setString(3,student.getGrade());
             pstmt.setFloat(4,student.getMark());
             rows = pstmt.executeUpdate();
            if(log)LogRowsAffected(rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    private static void LogRowsAffected(int rows) {
        log.info("Rows affected : " + rows);
    }



    @Override
    public int delete(int id ,boolean log) {
        int rows = 0;
        String sql = "DELETE FROM student WHERE id = " + id + ";";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            rows = stmt.executeUpdate(sql);
            if(log)LogRowsAffected(rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public int delete(boolean log,int... ids) {
        int rows = 0;
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            for (int id : ids) {
                rows += stmt.executeUpdate("DELETE FROM student WHERE id = " + id + ";");
            }
            if(log)LogRowsAffected(rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
