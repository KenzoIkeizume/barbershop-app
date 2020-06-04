package core.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import core.barbershop.model.Company;

public interface CompanyRepository extends JpaRepository <Company, Integer> {

}