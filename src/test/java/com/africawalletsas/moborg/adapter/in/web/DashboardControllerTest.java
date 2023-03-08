package com.africawalletsas.moborg.adapter.in.web;

import com.africawalletsas.moborg.domain.HuddleService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DashboardControllerTest {

    @Test
    void givenOneHuddleResultsInHuddlePutIntoModel() {
        HuddleService huddleService = new HuddleService(null);
        DashboardController dashboardController = new DashboardController(huddleService);

        Model model = new ConcurrentModel();
        dashboardController.dashboardView(model);

        List<HuddleSummaryView> huddleSummaryViews = (List<HuddleSummaryView>) model.getAttribute("huddles");

        assertThat(huddleSummaryViews).hasSize(1);
    }

}