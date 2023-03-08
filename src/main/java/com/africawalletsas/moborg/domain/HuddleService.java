package com.africawalletsas.moborg.domain;

import java.time.ZonedDateTime;
import java.util.List;

public class HuddleService {

    private final HuddleRepository huddleRepository;

    public HuddleService(HuddleRepository huddleRepository) {
        this.huddleRepository = huddleRepository;
    }

    public List<Huddle> activeHuddles() {
        Huddle huddle = new Huddle("Name", ZonedDateTime.now());
        return List.of(huddle);
    }

    public void scheduleHuddle(String name, ZonedDateTime zonedDateTime) {
        Huddle huddle = new Huddle(name, zonedDateTime);
        huddleRepository.save(huddle);
    }

    public List<Huddle> allHuddles() {
        return huddleRepository.findAll();
    }
}
