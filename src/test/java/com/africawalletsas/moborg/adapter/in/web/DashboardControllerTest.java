package com.africawalletsas.moborg.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DashboardControllerTest {

    @Test
    void givenOneHuddleResultsInHuddlePutIntoModel() {
        DashboardController dashboardController = new DashboardController();

        Model model = new ConcurrentModel();
        dashboardController.dashboardView(model);

        List<Huddle> huddles = (List<Huddle>) model.getAttribute("huddles");

        assertThat(huddles).hasSize(1);
    }

}