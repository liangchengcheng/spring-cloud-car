package com.hdsx.car.model;

import java.util.List;

public class Pagination <T> {

    // 总记录条数
    private int totalCount;
    // 总页码
    private int totalPage;
    // 页面大小
    private int pageSize;
    // 当前第几页
    private int pageNo;
    // 返回记录条数
    private List<T> list;
    //图表数据
    private List<T> tbList;

    private int startRow;


    public Pagination() {
        super();
    }

    public Pagination(int pageNo, int pageSize ) {
        super();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        //默认一页显示10条记录
        if (this.pageSize == 0) {
            this.pageSize = 10;
        }
        //默认显示第一页
        if (this.pageNo == 0) {
            this.pageNo = 1;
        }
        //计算总页数
        if(totalCount>0){
            //总记录数除以页面大小计算总页数
            int tPage = totalCount / this.pageSize;
            //有余数,总页数加1
            if (totalCount > tPage * this.pageSize) {
                tPage += 1;
            }
            this.totalPage = tPage;

        }else{//总记录数等于0
            this.pageNo = 1;
            this.startRow=0;
            this.totalPage=0;
        }
        //计算当前开始行
        int startRow =(this.pageNo-1)*this.pageSize;
        this.startRow = startRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public List<T> getTbList() {
        return tbList;
    }

    public void setTbList(List<T> tbList) {
        this.tbList = tbList;
    }

}
