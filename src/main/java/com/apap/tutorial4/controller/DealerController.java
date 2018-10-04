package com.apap.tutorial4.controller;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.service.CarService;
import com.apap.tutorial4.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DealerController {
    @Autowired
    private DealerService dealerService;

    @Autowired
    private CarService carService;

    @RequestMapping("/")
    private String home(){
        return "home";
    }

    @RequestMapping(value = "/dealer/view", method = RequestMethod.GET)
    private String findDealer(Model model, @RequestParam String dealerId){
        DealerModel result = dealerService.getDealerDetailById(Long.parseLong(dealerId)).get();
        dealerService.getDealerDetailById(Long.parseLong(dealerId)).get().getListCar().sort((car1,car2)-> {return(car1.getPrice()>car2.getPrice()?1:-1);});
        List <CarModel> list = dealerService.getDealerDetailById(Long.parseLong(dealerId)).get().getListCar();

        model.addAttribute("result", result);
        model.addAttribute("list", list);
        return "view-dealer";
    }

    @RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
    private String add(Model model){
        model.addAttribute("dealer", new DealerModel());
        return "addDealer";
    }

    @RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
    private String addDealerSubmit(@ModelAttribute DealerModel dealer){
        dealerService.addDealer(dealer);
        return "add";
    }

    @RequestMapping(value = "/dealer/delete{dealerId}", method = RequestMethod.GET)
    private String updateDealerSubmit(@PathVariable(value = "dealerId") Long dealerId) {
        dealerService.deleteDealerById(dealerId);
        return "delete";
    }
}
