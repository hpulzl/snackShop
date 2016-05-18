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
		pd.setPdtype("ˮ��");
		pd.setPdname("�㽶");
		pd.setPdimage("12.jpg");
		pd.setDisprice(2.5F);
		pd.setPddetail("�츻ʿƻ����ʮ�ֺóԣ�");
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
		pd.setPdtype("ˮ��");
		pd.setPdname("�㽶");
		pd.setPdimage("12.jpg");
		pd.setDisprice(2.5F);
		pd.setPdid("fa891454-ef09-4b96-b0ed-f94e96a0b48d");
		pd.setPddetail("̩��С�㽶��ʮ�ֺóԣ�");
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
			System.out.println("��ҳ��:"+ps.pageTotal("ˮ"));
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
			List<Productdetail> list= ps.selectByPdExample("ˮ��", 1);
			System.out.println("��ѯ����:"+list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
