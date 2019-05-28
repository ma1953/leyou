package leyou.common;

import java.util.List;

public class ResultPage<T> {
    private  Long total;
    private  Long totalPage;
    private List<T> items;

    public ResultPage() {
    }

    public ResultPage(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public ResultPage(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ResultPage{" +
                "total=" + total +
                ", totalPage=" + totalPage +
                ", items=" + items +
                '}';
    }
}
