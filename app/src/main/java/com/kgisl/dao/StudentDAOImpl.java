package com.kgisl.dao;


import com.kgisl.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE id=?";
    private static final String INSERT_STUDENT = "INSERT INTO students (id, name, email, address) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_STUDENT = "UPDATE students SET name=?, email=?, address=? WHERE id=?";
    private static final String DELETE_STUDENT_BY_ID = "DELETE FROM students WHERE id=?";

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_STUDENTS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findById(Long id) {
        Student student = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SELECT_STUDENT_BY_ID)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setAddress(rs.getString("address"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void save(Student student) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(INSERT_STUDENT)) {
            stmt.setLong(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getAddress());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(DELETE_STUDENT_BY_ID)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_STUDENT)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getAddress());
            stmt.setLong(4, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
