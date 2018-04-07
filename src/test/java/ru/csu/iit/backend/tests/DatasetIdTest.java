package ru.csu.iit.backend.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.DatasetModel;
import ru.csu.iit.backend.models.RowModel;
import ru.csu.iit.backend.services.DatasetsService;
import ru.csu.iit.backend.services.RowsCountService;
import ru.csu.iit.backend.services.RowsService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DatasetIdTest extends BaseTest {

    @Test(groups = "ivt-146")
    public void getDatasetId() {
        DatasetsService datasetsService = new DatasetsService(properties);
        RequestSpecification requestSpecification = datasetsService.request()
                .top(10)
                .contains("Caption", "Объекты ритуального обслуживания")
                .getFields("Id", "Caption")
                .build();
        DatasetModel[] datasets = datasetsService.execute(requestSpecification);

        for (DatasetModel dataset : datasets) {
            assertThat(dataset.getCaption(), containsString("Объекты ритуального обслуживания"));
        }

        int id = datasets[0].getId();
        logger.info("ID : " + id);
    }

    @Test(groups = "ivt-146")
    public void getDatasetData() {
        RowsService rowsService = new RowsService(properties);
        RequestSpecification requestSpecification = rowsService.request()
                .top(3)
                .getFields("Number")
                .build();
        RowModel[] rows = rowsService.execute(requestSpecification);

        int i = 1;
        for (RowModel row : rows) {
            assertThat(row.getNumber(), equalTo(i++));
            //logger.info("Name : " + row.getNumber());
        }
    }

    @Test(groups = "ivt-148")
    public void RowsCount() {
        RowsCountService rowsCountService = new RowsCountService(properties);
        RequestSpecification requestSpecification = rowsCountService.request().build();
        int count = rowsCountService.execute(requestSpecification);

        logger.info("Count: " + count);
        assertThat(count, equalTo(140));
    }
}
