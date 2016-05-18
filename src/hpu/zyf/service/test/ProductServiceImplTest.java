package hpu.zyf.service.test;

import hpu.zyf.entity.Productdetail;
import hpu.zyf.service.ProductService;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductServiceImplTest{
	private ProductService ps;
	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/application-dao.xml"
				,"classpath:mybatis/sqlMapConfig.xml","classpath:spring/application-service.xml"});
		ps = (ProductService) context.getBean("productService");
	}

	@Test
	public void testInserProduct() {
		Productdetail pd = new Productdetail();
		pd.setPdtype("水果");
		pd.setPdname("香蕉");
		pd.setPdimage("12.jpg");
		pd.setDisprice(2.5F);
		pd.setPddetail("红富士苹果，十分好吃！");
		try {
			for(int i=0;i<10;i++){
				ps.inserProduct(pd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateProduct() {
		Productdetail pd = new Productdetail();
		pd.setPdtype("水果");
		pd.setPdname("香蕉");
		pd.setPdimage("12.jpg");
		pd.setDisprice(2.5F);
		pd.setPdid("fa891454-ef09-4b96-b0ed-f94e96a0b48d");
		pd.setPddetail("泰国小香蕉，十分好吃！");
		try {
			ps.updateProduct(pd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteProduct() {
		try {
			ps.deleteProduct("ab0ee139-8455-42f2-9d6e-dcd53c5c744e");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testpageTotal(){
		try {
			System.out.println("总页数:"+ps.pageTotal("水"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSelectByPdid() {
		try {
		Productdetail pd =	ps.selectByPdid("aeb0bae6-d677-4ac5-b9d0-732a35208563");
		System.out.println(pd.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectByPdExample() {
		try {
			List<Productdetail> list= ps.selectByPdExample("水果", 1);
			System.out.println("查询个数:"+list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
