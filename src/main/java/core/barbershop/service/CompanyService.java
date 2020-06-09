package core.barbershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.barbershop.model.Company;
import core.barbershop.repository.CompanyRepository;

/**
 * CompanyService
 */
@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Company postCompany(Company company) {
        if (!company.isValid()) {
            throw new Error("Invalid company");
        }

        Company newCompany = this.companyRepository.save(company);

        return newCompany;
    }

    public List<Company> findAllCompany() {
      List<Company> companies = this.companyRepository.findAll();

      return companies;
    }

    public Company getCompany(int id)
    {
        Company company = this.companyRepository.getOne(id);

        return company;
    }

    public void deleteCompany(int id)
    {
        this.companyRepository.deleteById(id);
    }
}