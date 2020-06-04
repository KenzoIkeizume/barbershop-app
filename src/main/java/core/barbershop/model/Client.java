package core.barbershop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

/**
 * Client
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phone;
    private int birth;

    @ManyToMany
    @JoinTable(
        name = "EmployeeClient", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_employee", "id_client" }), 
        joinColumns = @JoinColumn(name = "id_client"),
        inverseJoinColumns = @JoinColumn(name = "id_employee")
    )
    private List<Employee> employees;

    @OneToMany()
    @JoinColumn(name = "id_schedule_client")
    private List<Schedule> schedules;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Schedule> getSchedules() {
      return schedules;
    }

    public boolean isValid() {
        return !(
            this.name == "" || 
            this.phone == "" || 
            this.birth < 1900 || 
            this.employees.size() <= 0
        );
    }
}