package com.muoverin.model;

import java.util.List;

public class Pagination<K> {

    private long currentPage;
    private long rowsInCurrentPage;
    private long pages;
    private long totalRows;
    private List<K> data;

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getRowsInCurrentPage() {
        return rowsInCurrentPage;
    }

    public void setRowsInCurrentPage(long rowsInCurrentPage) {
        this.rowsInCurrentPage = rowsInCurrentPage;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public List<K> getData() {
        return data;
    }

    public void setData(List<K> data) {
        this.data = data;
    }

}
