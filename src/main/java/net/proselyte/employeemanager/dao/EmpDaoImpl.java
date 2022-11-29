package net.proselyte.employeemanager.dao;

import net.proselyte.employeemanager.model.employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoImpl implements EmployeeDao {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDao.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEmployee(employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
        logger.info("Employeers successfully saved. Employeer details" + employee);
    }

    @Override
    public void updateEmployee(employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);
        logger.info("Employeer successfully update. Employeer details" + employee);
    }

    @Override
    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        employee employee = (employee) session.load(net.proselyte.employeemanager.model.employee.class, new Integer(id));
        if (employee!=null){
            session.delete(employee);
        }
        logger.info("Employeer successfully remove. Employeer details:" + employee);
    }

    @Override
    public employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        employee employee = (net.proselyte.employeemanager.model.employee) session.load(employee.class, new Integer (id));
        logger.info("Employeer successfully remove. Employeer details:"+ employee);
        return employee;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<employee> listEmployee() {
        Session session =this.sessionFactory.getCurrentSession();
        List<employee> employeesList = session.createQuery("from employee").list();
        for(employee employee: employeesList){
            logger.info("employee list" + employee);
        }
        return employeesList;
    }
}
