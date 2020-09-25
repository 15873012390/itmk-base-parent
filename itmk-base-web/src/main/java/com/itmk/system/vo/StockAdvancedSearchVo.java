package com.itmk.system.vo;

public class StockAdvancedSearchVo {
    private Integer stockId;
    private Integer stockQuantity;
    private String proName;
    private String warehouseId[];
    private String stockNumSelect;
    private Integer currentPage;
    private Integer pageSize;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String[] getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String[] warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStockNumSelect() {
        return stockNumSelect;
    }

    public void setStockNumSelect(String stockNumSelect) {
        this.stockNumSelect = stockNumSelect;
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
