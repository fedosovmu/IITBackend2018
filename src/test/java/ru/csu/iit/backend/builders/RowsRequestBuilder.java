package ru.csu.iit.backend.builders;

import io.restassured.specification.RequestSpecification;

public class RowsRequestBuilder {
    private RequestSpecification requestSpecification;

    public RowsRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public RowsRequestBuilder top(int top) {
        requestSpecification.queryParams("$top", top);
        return this;
    }

    public RowsRequestBuilder getFields(String... fields) {
        requestSpecification.body(fields);
        return this;
    }

    public RequestSpecification build() {
        return requestSpecification;
    }
}
