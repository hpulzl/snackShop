package hpu.zyf.service.test;

import hpu.zyf.entity.Discountproduct;
import hpu.zyf.entity.Productdetail;
import hpu.zyf.entity.vo.ProductdetailVo;
import hpu.zyf.service.DisCountProductService;
import hpu.zyf.service.ProductService;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisProductServiceImplTest{
	private DisCountProductService dcps;
	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/application-dao.xml"
				,"classpath:mybatis/sqlMapConfig.xml","classpath:spring/application-service.xml"});
		dcps = (DisCountProductService) context.getBean("discountProductService");
	}

	@Test
	public void testInserProduct() {
		ProductdetailVo vo = new ProductdetailVo();
		Productdetail pd = new Productdetail();
		Discountproduct dp = new Discountproduct();
		pd.setCreatetime(new Date());
		pd.setPdtype("蔬菜");
		pd.setDisprice(3.4F);
		pd.setPdprice(5.6F);
		pd.setPdimage("23.jpg");
		pd.setPdname("鸡蛋");
		pd.setPddetail("土家鸡蛋，私人定制");
		dp.setEndtime(new Date());
		dp.setStarttime(new Date());
		vo.setProDetail(pd);
		vo.setDisProduct(dp);
		
		try {
			dcps.inserDisProduct(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateProduct() {
		
	}

	@Test
	public void testDeleteProduct() {
	}
	@Test
	public void testpageTotal(){
		try {
			System.out.println("总页码"+dcps.pageTotal(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSelectByPdid() {
		try {
			dcps.selectDisByPdid("02a15465-8c84-4d90-9015-b9bf7e811464");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectByPdExample() {
		try {
			dcps.selectByDisPdExample("", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
