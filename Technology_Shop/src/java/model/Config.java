/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84877
 */
public class Config {
     private int size;
    private int nrpp;
    private int pageIndex;
    private int begin;
    private int end;
    private int totalPage;
    private int pageStart;
    private int pageEnd;

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    public int getNrpp() {
        return nrpp;
    }

    public void setNrpp(int nrpp) {
        this.nrpp = nrpp;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }   
    
    public Config() {
    }

    public Config(int totalPage, int nrpp, int pageIndex) {
        this.totalPage = totalPage;
        this.nrpp = nrpp;
        this.pageIndex = pageIndex;
        pageStart = pageIndex-1;
        pageEnd = pageIndex +1;
        pageStart = pageStart<1?1 : pageStart;
        pageEnd = pageEnd>totalPage?totalPage : pageEnd;
    }
    
    public int getSize(){
        return size;
    }
}
