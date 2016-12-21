package fr.deix.springmvc.web.controller;

import fr.deix.springmvc.bean.RechercheViewBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Amo on 27/06/2015.
 */
@Controller
@SessionAttributes("recherche")
public class RechercherController {

    @InitBinder
    void allowFields(WebDataBinder webDataBinder){
        webDataBinder.setAllowedFields("code");
    }

    @RequestMapping(value="/displayRecherche", method = RequestMethod.GET)
    public String display(Model model) {
        if (!model.containsAttribute("recherche")) {
            model.addAttribute("recherche", new RechercheViewBean());
        }

        return "recherche";
    }

    @RequestMapping(value="/rechercher", method = RequestMethod.POST)
    public String rechercher(@ModelAttribute("code") @Valid RechercheViewBean rechercheViewBean, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        RechercheViewBean rechercheDto = new RechercheViewBean();
        rechercheDto.setAutre("Je suis un DTO");
        rechercheDto.setCode(rechercheViewBean.getCode());
//        model.addAttribute("recherche", rechercheDto);

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.recherche", result);
        }

        redirectAttributes.addFlashAttribute("recherche", rechercheDto);

        return "redirect:displayRecherche";
    }
}
