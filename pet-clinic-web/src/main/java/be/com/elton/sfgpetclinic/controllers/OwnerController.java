package be.com.elton.sfgpetclinic.controllers;

import be.com.elton.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    private static final String CATEGORY_ENDPOINT = "/owners";
    private static final String CATEGORY_ENDPOINT_ID = CATEGORY_ENDPOINT + "/{id}";
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){

        return "notimplemented";
    }

}
