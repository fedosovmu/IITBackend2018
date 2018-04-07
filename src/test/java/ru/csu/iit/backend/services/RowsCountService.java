package ru.csu.iit.backend.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.DatasetRequestBuilder;
import ru.csu.iit.backend.builders.RowsRequestBuilder;
import ru.csu.iit.backend.models.RowModel;

import java.util.Properties;

public class RowsCountService extends BaseService {
    public RowsCountService(Properties properties) {
        super(properties);
    }

    public DatasetRequestBuilder request() { return new DatasetRequestBuilder(baseRequest()); }

    public int execute(RequestSpecification requestSpecification) {
        return requestSpecification.get("datasets/" + properties.getProperty("dataset_id") + "/count").then()
                .extract()
                .body().as(int.class);
    }
}
