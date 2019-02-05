package uk.co.datadisk.jpa1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.datadisk.jpa1.entities.NationalInsuranceNumber;
import uk.co.datadisk.jpa1.entities.User;
import uk.co.datadisk.jpa1.services.NatService;
import uk.co.datadisk.jpa1.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/nat/")
public class NatController {

    private NatService natService;

    public NatController(NatService natService) {
        this.natService = natService;
    }

    @GetMapping("listAllNats")
    public List<NationalInsuranceNumber> listAllNats() {
        List<NationalInsuranceNumber> nationalInsuranceNumbers = natService.findAll();
        return nationalInsuranceNumbers;
    }

    @GetMapping("findNat/{id}")
    public NationalInsuranceNumber findUser(@PathVariable Long id) {
        NationalInsuranceNumber nat = natService.findById(id);
        return nat;
    }
}
