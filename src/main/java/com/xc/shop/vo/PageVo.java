package com.xc.shop.vo;

/**
 * @Description:
 * @Param:
 * @return
 * @Author: zhanghuajian
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
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer pageNum) {
        this.currentPage = pageNum;
    }
}
