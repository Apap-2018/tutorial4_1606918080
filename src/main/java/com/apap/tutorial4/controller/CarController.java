package com.apap.tutorial4.controller;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.service.CarService;
import com.apap.tutorial4.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private DealerService dealerService;

    @RequestMapping(value = "/car/add/{dealerId}", method = RequestMethod.GET)
    private String add(@PathVariable(value = "dealerId") Long dealerId, Model model){
        CarModel car = new CarModel();
        DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
        car.setDealer(dealer);

        model.addAttribute("car", car);
        return "addCar";
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    private String addCarSubmit(@ModelAttribute CarModel car){
        carService.addCar(car);
        return "add";
    }

}
