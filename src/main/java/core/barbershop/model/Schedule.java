package core.barbershop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Schedule
 */
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String scheduledTime;

    @ManyToOne()
    @JoinColumn(name = "id_schedule_client")
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "id_schedule_company")
    private Company company;

    @ManyToOne()
    @JoinColumn(name = "id_schedule_employee")
    private Employee employee;

    public int getId() {
        return id;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}