package hpu.zyf.service.test;

import static org.junit.Assert.*;
import hpu.zyf.entity.Orderdetail;
import hpu.zyf.service.AddShopCartService;
import hpu.zyf.service.DisCountProductService;
import hpu.zyf.service.impl.AddShopCartServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.portable.Delegate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddShopCartServiceImplTest {

	private AddShopCartService as; 
	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/application-dao.xml"
				,"classpath:mybatis/sqlMapConfig.xml","classpath:spring/application-service.xml"});
		as = (AddShopCartService) context.getBean("addShopCartService");
	}

	@Test
	public void testAddShopCart() {
		Orderdetail detail = new Orderdetail();
		detail.setOdnumber(3);
		detail.setOdprice(13.5F);
		try {
			as.addShopCart("7671d5e3-002e-4813-b9e6-0577278f12de", "04861b4b-1df1-4e22-a84a-10aaac79967b", detail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteShopCartByUserid() {
		try {
			as.deleteShopCartByUserid("7671d5e3-002e-4813-b9e6-0577278f12de", "8823bef6-bd3c-4bd6-bb2f-786e8f81670a","a0ea62d7-ad7a-4647-afa5-6ccd8e8c9576");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteShopCartByOrderid() {
		try {
			as.deleteShopCartByOrderid("762751a3-9a31-42c6-8fd4-ee566e042ff5", "349c76df-c9b1-4de0-8a62-ff15622169f8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectByUserid() {
		try {
			as.selectByUserid("7671d5e3-002e-4813-b9e6-0577278f12de");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//payByUser
	@Test
	public void testpayByUser() {
		try {
			as.payByUser("da8b0d73-f82b-42d3-854e-939a48f707a0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
