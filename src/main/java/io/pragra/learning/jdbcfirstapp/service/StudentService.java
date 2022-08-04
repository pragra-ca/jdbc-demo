package io.pragra.learning.jdbcfirstapp.service;

import io.pragra.learning.jdbcfirstapp.entity.Student;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    private JdbcTemplate template;

    public StudentService(JdbcTemplate template) {
        this.template = template;
    }
    //CRUD
    public int createStudent(Student student) {

        String sql =
                "INSERT INTO TABLE_STUDENT VALUES(?,?,?,?,?,?,?)";
        return this.template.update(sql,
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getJoinDate(),
                new Date(),
                new Date(),
                student.getCourse()
                );
    }

    public List<Student> getAllStudent() {
        String sql = "SELECT * FROM TABLE_STUDENT";
        return this.template.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    public Student getOneById(int id) {
        String sql = "SELECT * FROM TABLE_STUDENT WHERE ID = ?";
        return this.template.queryForObject(sql,
                new Object[]{id}, new int[]{Type.INT},
                new BeanPropertyRowMapper<>(Student.class)
        );
    }
}
