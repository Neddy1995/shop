package com.xc.shop.vo;

/**
 * @Description:
 * @Param:
 * @return
 * @Author: xc
 * @CreateDate: 2019/3/29 15:58
 */
public class PageVo {

    // 每页数量，默认5
    private Integer pageSize = 5;

    // 默认第1页
    private Integer currentPage = 1;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null || pageSize != 0)
            this.pageSize = pageSize ;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage != null || currentPage != 0)
            this.currentPage = currentPage;
    }
}
