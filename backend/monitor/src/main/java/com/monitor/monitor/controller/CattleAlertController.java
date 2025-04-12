package com.monitor.monitor.controller;
import com.monitor.monitor.model.CattleAlert;
import com.monitor.monitor.service.CattleAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/alerts")
@CrossOrigin(origins = "http://localhost:5173")
public class CattleAlertController {

    @Autowired
    private CattleAlertService service;

    @GetMapping
    public List<CattleAlert> getAlerts() {
        return service.getAllAlerts();
    }

    @DeleteMapping("/clear")
    public void clearProgress() {
        service.clearAlerts();
    }
}