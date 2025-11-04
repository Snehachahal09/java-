package com.sms.service;

import com.sms.dao.StudentDAO;
import com.sms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentDAO dao;

    @Transactional
    public void addStudent(String name, String course, double fee) {
        dao.save(new Student(name, course, fee));
    }

    @Transactional(readOnly = true)
    public void viewStudents() {
        dao.getAll().forEach(
            s -> System.out.println(s.getId()+" | "+s.getName()+" | "+s.getCourse()+" | "+s.getFee())
        );
    }

    @Transactional
    public void payFee(int id, double amount) {
        Student s = dao.get(id);
        s.setFee(s.getFee() - amount);
        dao.update(s);
        System.out.println("✅ Payment Successful");
    }

    @Transactional
    public void refundFee(int id, double amount) {
        Student s = dao.get(id);
        s.setFee(s.getFee() + amount);
        dao.update(s);
        System.out.println("✅ Refund Successful (Transaction Safe)");
    }

    @Transactional
    public void deleteStudent(int id) {
        dao.delete(id);
    }
}
