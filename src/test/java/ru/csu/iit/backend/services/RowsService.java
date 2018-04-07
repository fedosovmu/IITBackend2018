package ru.csu.iit.backend.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.RowsRequestBuilder;
import ru.csu.iit.backend.models.RowModel;

import java.util.Properties;

public class RowsService extends BaseService{
    public RowsService(Properties properties) {
        super(properties);
    }

    public RowsRequestBuilder request() { return new RowsRequestBuilder(baseRequest()); }

    public RowModel[] execute(RequestSpecification requestSpecification) {
        return requestSpecification.post("datasets/" + properties.getProperty("dataset_id") + "/rows").then()
                .extract()
                .body().as(RowModel[].class);
    }
}
