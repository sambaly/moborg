package com.africawalletsas.moborg.adapter.in.web;

import com.africawalletsas.moborg.domain.Huddle;
import com.africawalletsas.moborg.domain.HuddleRepository;
import com.africawalletsas.moborg.domain.HuddleService;
import com.africawalletsas.moborg.domain.InMemoryHuddleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DashboardControllerTest {

    @Test
    void givenOneHuddleResultsInHuddleIntoViewModel() {
        HuddleRepository huddleRepository = new InMemoryHuddleRepository();
        HuddleService huddleService = new HuddleService(huddleRepository);
        huddleRepository.save(new Huddle("Name", ZonedDateTime.now()));
        DashboardController dashboardController = new DashboardController(huddleService);

        Model model = new ConcurrentModel();
        dashboardController.dashboardView(model);

        List<HuddleSummaryView> huddleSummaryViews = (List<HuddleSummaryView>) model.getAttribute("huddles");

        assertThat(huddleSummaryViews).hasSize(1);
    }

    @Test
    void scheduleNewHuddleResultsInHuddleCreatedInRepository() {
        HuddleRepository huddleRepository = new InMemoryHuddleRepository();
        HuddleService huddleService = new HuddleService(huddleRepository);
        DashboardController dashboardController = new DashboardController(huddleService);

        String pageName = dashboardController.scheduleHuddle(
                new ScheduleHuddleForm("Name", "2021-04-30", "10:00"));

        assertThat(pageName).isEqualTo("redirect:/dashboard");
        assertThat(huddleRepository.findAll()).hasSize(1);
    }

}