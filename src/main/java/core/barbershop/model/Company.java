package core.barbershop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Company
 */
@Entity
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String founder;
    private String specialty;

    @OneToMany()
    @JoinColumn(name = "id_company")
    private List<Employee> employees;

    @OneToMany()
    @JoinColumn(name = "id_schedule_company")
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
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
            this.founder == "" || 
            this.specialty == ""
        );
    }
}