package com.monitor.monitor.service;
import com.monitor.monitor.model.CattleAlert;
import com.monitor.monitor.repository.CattleAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CattleAlertService {
    @Autowired
    private final CattleAlertRepository repository;

    public CattleAlertService(CattleAlertRepository repository) {
        this.repository = repository;
    }

    public List<CattleAlert> getAllAlerts() {
        return repository.findAll();
    }

    public void clearAlerts() {
        repository.resetProgress();
    }
}