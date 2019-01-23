//package com.github.czyzowicz.controller;
//
//import com.github.czyzowicz.dto.BookDto;
//import com.github.czyzowicz.model.Rent;
//import com.github.czyzowicz.service.RentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/api/rent")
//public class RentController {
//
//    private RentService rentService;
//
////    @Autowired
////    public RentController(RentService rentService) {
////        this.rentService = rentService;
////    }
//
//    @PostMapping
//    public void create (@RequestParam Set<Long> bookIds){
//        rentService.create(bookIds);
//    }
//
////    @GetMapping
////    public  Set<Rent> bookIds findAll () {
////        return rentService.findAll(rent);
////    }
//
//
//}
