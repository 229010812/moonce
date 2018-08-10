package com.moonce.doman.vo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 自定义分页返回VO
 * @param <T>
 */
public class PageVo<T> {
    /** 当前页数*/
    private Integer pageNum;
    /** 总页数*/
    private Integer totalPages;
    /** 总数*/
    private long total;
    /** 每页展示*/
    private Integer pageSize;
    /** 数据*/
    private List<T> list;

    public java.lang.Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(java.lang.Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public java.lang.Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(java.lang.Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageVo() {
    }

    public PageVo(Page<T> page) {
        this.pageNum = page.getNumber()+1;
        this.totalPages = page.getTotalPages();
        this.total = page.getTotalElements();
        this.pageSize = page.getSize();
        this.list = page.getContent();
    }
}
