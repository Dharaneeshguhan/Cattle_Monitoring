package com.monitor.monitor.repository;

import com.monitor.monitor.model.CattleAlert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CattleAlertRepository {
    private final List<CattleAlert> alerts = new ArrayList<>();

    public CattleAlertRepository() {
        alerts.add(new CattleAlert(1L, 10, 3)); // 30%
        alerts.add(new CattleAlert(2L, 10, 8)); // 80%
    }

    public List<CattleAlert> findAll() {
        return alerts;
    }

    public void resetProgress() {
        alerts.clear();
    }
}
