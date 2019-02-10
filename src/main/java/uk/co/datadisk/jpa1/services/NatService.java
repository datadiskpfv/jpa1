package uk.co.datadisk.jpa1.services;

import uk.co.datadisk.jpa1.entities.NationalInsuranceNumber;
import uk.co.datadisk.jpa1.entities.User;

import java.util.List;

public interface NatService {

    // need CRUD methods
    // CREATE


    // READ
    NationalInsuranceNumber findById(Long id);

    List<NationalInsuranceNumber> findAll();

    // UPDATE


    // DELETE

}
