package cn.zgys.wifi.entity;

import java.util.List;

public class PageBean {

    private int pageNumber;//当前页码
    private int pageSize;//每页显示的行数
    private int index;//从数据库哪一行开始获取数据
    private long total;//总行数
    private long totalPage;
    private String sort;
    private String order;
    private List<?> rows;

    public PageBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PageBean(int pageNumber, int pageSize, String sort, String order) {
        super();
        index = (pageNumber - 1) * pageSize;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = sort;
        this.order = order;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        totalPage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize) + 1;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PageBean [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", index=" + index + ", total=" + total
                + ", totalPage=" + totalPage + ", sort=" + sort + ", order=" + order + ", rows=" + rows + "]";
    }
}
