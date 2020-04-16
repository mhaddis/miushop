package com.ea.miushop.controller;

import com.ea.miushop.domain.Inventory;
import com.ea.miushop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping(value = "all")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @GetMapping(value = "{inventoryId}")
    public Inventory getInventoryById(@PathVariable Long inventoryId){
        return inventoryService.getInventory(inventoryId);
    }

    @PostMapping(value = "new-inventory", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public void enterInventory(@RequestBody Inventory inventory){
        inventoryService.enterInventory(inventory);
    }
}
