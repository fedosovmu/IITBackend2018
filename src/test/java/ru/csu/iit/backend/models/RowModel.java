package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RowModel {

    @JsonProperty(value = "global_id")
    private int id;
    @JsonProperty(value = "Number")
    private int number;
    @JsonProperty(value = "Cells")
    private Object cells;

    public Object getCells() { return cells; }

    public void setCells(Object cells) { this.cells = cells; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    @Override
    public String toString() {
        return "RowModel{" +
                "id=" + id +
                ", Number=" + number +
                '}';
    }
}
