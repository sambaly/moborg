package com.africawalletsas.moborg.domain;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class HuddleServiceScheduleTest {

    @Test
    void singleScheduledHuddleIsReturnedForAllHuddles() {
        HuddleService huddleService = new HuddleService(new InMemoryHuddleRepository());

        huddleService.scheduleHuddle("Name", ZonedDateTime.now());

        assertThat(huddleService.allHuddles())
                .hasSize(1);
    }
}