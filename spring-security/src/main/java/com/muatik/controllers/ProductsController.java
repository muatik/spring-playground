package com.muatik.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mustafaatik on 26/12/16.
 */
@RestController
@RequestMapping("/products/")
public class ProductsController {

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "products";
    }

}
