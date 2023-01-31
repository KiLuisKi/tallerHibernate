package org.springframework.samples.petclinic;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.owner.Bill;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
	
	
	

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HibernateApplication.class, args);
        
    }
    
    
    
    @Override
    @Transactional
    public void run(String... arg0) {
    	Bill b = new Bill();
    	b.setId(1234567890);
    	b.setMoney(1.0);
    	b.setPaymentDate(new Date());
    	List<Bill> listaFacturas = new ArrayList<Bill>();
    	listaFacturas.add(b);
    	listaFacturas = billRepository.save(listaFacturas);
    	visits.get(0).setBill(b);
    	visitRepository.save(visits.get(0));

    	p = petRepository.findById(8);
    	visits = visitRepository.findByPetId(p.getId());
    	for(Visit v : visits) {
    		System.out.println(v.toString());
    	}	

		
		
	
		}	
    }


