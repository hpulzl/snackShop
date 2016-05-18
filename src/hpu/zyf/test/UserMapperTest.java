package hpu.zyf.test;

import static org.junit.Assert.*;
import hpu.zyf.entity.User;
import hpu.zyf.mapper.UserMapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest {
	public UserMapper um;
	@Before
	public void setUp() throws Exception {
		um = MapperInstance.getMappperInstance("userMapper");
	}

	@Test
	public void testCountByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		System.out.println(um.toString());
		User u = new User();
		u.setUserid("123");
		u.setUsername("lzl");
		u.setUserpassword("123456");
		u.setUserphone("18939171376");
		System.out.println(um.insert(u));
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPhone() {
		hpu.zyf.entity.User u = (hpu.zyf.entity.User) um.selectByPhone("18939171376");
		System.out.println(u.toString());
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
