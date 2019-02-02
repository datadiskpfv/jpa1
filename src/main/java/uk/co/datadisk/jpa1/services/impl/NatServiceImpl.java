package uk.co.datadisk.jpa1.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.co.datadisk.jpa1.entities.NationalInsuranceNumber;
import uk.co.datadisk.jpa1.exceptions.NotFoundException;
import uk.co.datadisk.jpa1.repositories.NatRepository;
import uk.co.datadisk.jpa1.services.NatService;

import java.util.List;

@Service
@Transactional
public class NatServiceImpl implements NatService {

    private NatRepository natRepository;

    public NatServiceImpl(NatRepository natRepository) {
        this.natRepository = natRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public NationalInsuranceNumber findById(Long id) {
        return natRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found. For ID value: " + id.toString()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<NationalInsuranceNumber> findAll() {

        List<NationalInsuranceNumber> nationalInsuranceNumbers = natRepository.findAll();
        System.out.println("Found Users");
        System.out.println("-----------------------------------");

        return nationalInsuranceNumbers;
    }


}
