package core.barbershop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

/**
 * Employee
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String occupation;
    private int salary;

    @ManyToMany
    @JoinTable(
        name = "EmployeeClient", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_employee", "id_client" }), 
        joinColumns = @JoinColumn(name = "id_employee"),
        inverseJoinColumns = @JoinColumn(name = "id_client")
    )
    private List<Client> clients;

    @ManyToOne()
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany()
    @JoinColumn(name = "id_schedule_Employee")
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Client> getClients() {
        return clients;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Schedule> getSchedules() {
      return schedules;
    }

    public boolean isValid() {
        return !(
            this.name == "" || 
            this.occupation == "" || 
            this.salary <= 0
        );
    }
}