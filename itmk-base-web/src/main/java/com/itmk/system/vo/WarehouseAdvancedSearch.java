package com.itmk.system.vo;


public class WarehouseAdvancedSearch {
    private int warehouseId;
    private String warehouseName;
    private String stockType[];
    private Integer currentPage;
    private Integer pageSize;

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String[] getStockType() {
        return stockType;
    }

    public void setStockType(String[] stockType) {
        this.stockType = stockType;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
