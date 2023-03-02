package com.africawalletsas.moborg.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.*;

class DashboardControllerTest {

    @Test
    void givenOneHuddleResultsInHuddlePutIntoModel() {
        DashboardController dashboardController = new DashboardController();

        Model model = new ConcurrentModel();
        dashboardController.dashboardView(model);

        assertThat(model.containsAttribute("huddles"))
                .isTrue();
    }

}