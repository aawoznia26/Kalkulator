package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    public void findCompanyWithPhaseInName(String phase){
        LOGGER.info("Search for company with phase: '" + phase + "' in name started");

        try {
            List<Company> foundCompanies = companyDao.retrieveCompaniesWithNamesPhrase("%" + phase + "%");
            if(foundCompanies.size()<1){
                LOGGER.error(SearchProcessingException.ERR_COMPANY_NOT_FOUND);
                throw new SearchProcessingException(SearchProcessingException.ERR_COMPANY_NOT_FOUND);
            }
            LOGGER.info(foundCompanies.size() + " companies have been found");

        } catch (SearchProcessingException e){

        }

    }

    public void findEmployeeWithPhaseInLastName(String phase){
        LOGGER.info("Search for employee with phase: '" + phase + "' in last name started");

        try {
            List<Employee> foundEmployees = employeeDao.retrieveEmployeesWithNamesPhrase("%" + phase + "%");
            if(foundEmployees.size()<1){
                LOGGER.error(SearchProcessingException.ERR_EMPLOYEE_NOT_FOUND);
                throw new SearchProcessingException(SearchProcessingException.ERR_EMPLOYEE_NOT_FOUND);
            }
            LOGGER.info(foundEmployees.size() + " employees have been found");

        } catch (SearchProcessingException e){

        }

    }
}
