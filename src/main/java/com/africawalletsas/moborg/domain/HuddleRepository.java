package com.africawalletsas.moborg.domain;

import java.util.List;

public interface HuddleRepository {
    Huddle save(Huddle huddle);

    List<Huddle> findAll();
}
