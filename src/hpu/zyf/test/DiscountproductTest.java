package hpu.zyf.test;

import hpu.zyf.entity.vo.ProductCustom;
import hpu.zyf.mapper.DiscountproductMapper;
import hpu.zyf.mapper.ProductTypeMapper;

import org.junit.Before;
import org.junit.Test;

public class DiscountproductTest {
	public DiscountproductMapper dpm;
	public ProductTypeMapper ptm;
	@Before
	public void setUp() throws Exception {
		dpm = MapperInstance.getMappperInstance("discountproductMapper");
		ptm = MapperInstance.getMappperInstance("productTypeMapper");
	}
	@Test
	public void testSelectByPrimary() {
		ProductCustom pvo= dpm.selectByPrimaryKey("123213123");
		System.out.println("----"+pvo.getPdname());
	}
	@Test
	public void testSelect() {
		try {
			ptm.selectAllPtType();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
