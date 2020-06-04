package core.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import core.barbershop.model.Schedule;

public interface ScheduleRepository extends JpaRepository <Schedule, Integer> {

}