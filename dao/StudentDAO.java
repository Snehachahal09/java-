package com.sms.dao;

import com.sms.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Student s) {
        sessionFactory.getCurrentSession().persist(s);
    }

    public List<Student> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Student", Student.class).list();
    }

    public Student get(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    public void update(Student s) {
        sessionFactory.getCurrentSession().update(s);
    }

    public void delete(int id) {
        Student s = get(id);
        if(s != null) sessionFactory.getCurrentSession().delete(s);
    }
}
