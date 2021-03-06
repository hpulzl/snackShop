package hpu.zyf.util;

import java.io.Serializable;

/**
 *  添加了页码的数据
 * @author admin
 *
 */
public class MyRowBounds implements Serializable{
 
    private static final long serialVersionUID = -2860692762946249134L;
     
    public final static int NO_ROW_OFFSET = 0;
    public final static int NO_ROW_LIMIT = Integer.MAX_VALUE;
    public final static MyRowBounds DEFAULT = new MyRowBounds();
    public final static int NO_PAGENUMBER = 0;
    public final static int pageCount = 10;
 
    //偏移量
    private int offset;
    //条数
    private int limit;
    //页码
    private int pageNumber;
    private int totalPage ;  //记录总共的页数
 
    public MyRowBounds() {
        this.offset = NO_ROW_OFFSET;
        this.limit = NO_ROW_LIMIT;
        this.pageNumber = NO_PAGENUMBER;
    }
 
    public MyRowBounds(int offset, int limit, int pageNumber) {
        this.offset = offset;
        this.limit = limit;
        this.pageNumber = pageNumber;
    }
     
    /**
     * 返回RowBounds实体信息
     * @param pageNumber 页码
     * @param pageSize 一页条数
     */
    public MyRowBounds(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.limit = pageSize;
        this.offset = (pageNumber - 1) * pageSize;
    }
	public int getOffset() {
        return offset;
    }
 
    public int getLimit() {
        return limit;
    }
 
    public int getPageNumber() {
        return pageNumber;
    }
 
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
 
    public void setLimit(int limit) {
        this.limit = limit;
    }

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * 计算总共有多少页
	 * @param totalCount  总记录数
	 * @param pageCount  一页显示的个数
	 * @return
	 */
    public static int pageTotal(int totalCount,int pageCot){
    	int pageTotal = totalCount / pageCot;
    	if(totalCount % pageCot >0){
    		return pageTotal+1;
    	}
		return pageTotal;
    }
}
