package core.barbershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.barbershop.model.Schedule;
import core.barbershop.repository.ScheduleRepository;

/**
 * ScheduleService
 */
@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule postSchedule(Schedule schedule) {
        if (!schedule.isValid()) {
            throw new Error("Invalid schedule");
        }

        Schedule newSchedule = this.scheduleRepository.save(schedule);

        return newSchedule;
    }

    public List<Schedule> findAllSchedule() {
      List<Schedule> schedules = this.scheduleRepository.findAll();
      
      return schedules;
    }

    public Schedule getSchedule(int id)
    {
        Schedule schedule = this.scheduleRepository.getOne(id);

        return schedule;
    }

    public void deleteSchedule(int id)
    {
        this.scheduleRepository.deleteById(id);
    }
}