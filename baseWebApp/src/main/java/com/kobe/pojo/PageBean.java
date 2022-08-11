package com.kobe.pojo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/4
 * @time 16:18
 * @note 页面数据存储对象
 */
public class PageBean<T> {
    /**
     * 页面数据集合
     */
    private List<T> pageData;

    /**
     * 页面总记录数
     */
    private int countData;

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public int getCountData() {
        return countData;
    }

    public void setCountData(int countData) {
        this.countData = countData;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageBean{");
        sb.append("pageData=").append(pageData);
        sb.append(", countData=").append(countData);
        sb.append('}');
        return sb.toString();
    }

    public PageBean() {
    }

    public PageBean(List<T> pageData, int countData) {
        this.pageData = pageData;
        this.countData = countData;
    }
}
