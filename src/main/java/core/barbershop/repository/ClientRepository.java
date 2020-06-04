package core.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import core.barbershop.model.Client;

public interface ClientRepository extends JpaRepository <Client, Integer> {

}