package com.example.javahans.controller;

import com.example.javahans.model.WmsOverseasOrder;
import com.example.javahans.service.OverseaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("owms")
public class OverseaOrderController {
    @Autowired
    private OverseaOrderService overseaOrderService;

    @GetMapping("index/{id}")
    public WmsOverseasOrder index(@PathVariable("id") Long id) {
        return this.overseaOrderService.queryById(id);
    }
}
