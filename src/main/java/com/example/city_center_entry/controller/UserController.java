package com.example.city_center_entry.controller;

import com.example.city_center_entry.entity.EntryRequestEntity;
import com.example.city_center_entry.enums.AuthorityType;
import com.example.city_center_entry.enums.RequestStatus;
import com.example.city_center_entry.model.EntryRequestForm;
import com.example.city_center_entry.repository.EntryRequestRepository;
import com.example.city_center_entry.repository.PurposeOfEntryEnumRepository;
import com.example.city_center_entry.repository.StreetEnumRepository;
import com.example.city_center_entry.service.SecurityContextService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ziadatel")
@AllArgsConstructor
public class UserController {

    private StreetEnumRepository streetEnumRepository;
    private SecurityContextService securityContextService;
    private EntryRequestRepository entryRequestRepository;
    private PurposeOfEntryEnumRepository purposeOfEntryEnumRepository;

    @GetMapping()
    public String getProfil(ModelMap model) {
        if (!securityContextService.hasAuthority(AuthorityType.USER)) {
            return "redirect:/";
        }
        model.addAttribute("user", securityContextService.getUser());
        return "ziadatel/profil";
    }

    @GetMapping("podat-ziadost")
    public String podatZiadost(ModelMap model) {
        if (!securityContextService.hasAuthority(AuthorityType.USER)) {
            return "redirect:/";
        }

        model.addAttribute("entryRequestForm", securityContextService.getUser().toEntryRequest());
        model.addAttribute("streets", streetEnumRepository.nacitajUlice());
        model.addAttribute("purposes", purposeOfEntryEnumRepository.loadEnum());
        return "ziadatel/podat-ziadost-form";
    }

    @PostMapping("podat-ziadost")
    public String podatZiadostOdoslat(ModelMap model, EntryRequestForm form) {
        if (!securityContextService.hasAuthority(AuthorityType.USER)) {
            return "redirect:/";
        }

        EntryRequestEntity entity = new EntryRequestEntity();
        entity.setUser(securityContextService.getUser());
        entity.setTypeOfPerson(form.getTypeOfPerson());
        entity.setName(form.getName());
        entity.setIdentifier(form.getIdentifier());
        entity.setPhone(form.getPhone());
        entity.setAddress(form.getAddress());
        entity.setEmail(form.getEmail());
        entity.setEcv(form.getEcv());
        entity.setWeightOfCar(form.getWeightOfCar());
        entity.setFactoryBrand(form.getFactoryBrand());
        entity.setPurposeOfEntry(purposeOfEntryEnumRepository.getById(form.getPurposeOfEntryId()));
        entity.setParking(form.isParking());
        entity.setParkingStreet(streetEnumRepository.najdiUlicuPodlaId(form.getParkingStreetId()));
        entity.setStatus(RequestStatus.PENDING);
        entryRequestRepository.save(entity);


        return "redirect:/ziadatel/zoznam-ziadosti";
    }

    @GetMapping("zoznam-ziadosti")
    public String zoznamZiadosti(ModelMap model) {
        if (!securityContextService.hasAuthority(AuthorityType.USER)) {
            return "redirect:/";
        }
        model.addAttribute("requests", entryRequestRepository.getAllByUserId(securityContextService.getUser().getId()));
        return "ziadatel/zoznam-ziadosti";
    }

    @GetMapping("zoznam-platieb")
    public String platby(ModelMap model){
        if (!securityContextService.hasAuthority(AuthorityType.USER)) {
            return "redirect:/";
        }
        return "ziadatel/zoznam-platieb";
    }
}