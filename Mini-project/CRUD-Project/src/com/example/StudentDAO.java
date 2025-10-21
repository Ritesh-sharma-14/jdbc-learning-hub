package com.example;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    // CREATE
    public void addStudent(Student student) {
        String query = "INSERT INTO students(name, email, age) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.executeUpdate();
            System.out.println("✅ Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // UPDATE
    public void updateStudent(int id, String name, String email, int age) {
        String query = "UPDATE students SET name=?, email=?, age=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, age);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("✅ Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

