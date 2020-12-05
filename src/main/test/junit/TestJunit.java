package junit;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sgcc.user.pojo.User;
import com.sgcc.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestJunit {
	
	private static Logger logger = Logger.getLogger(TestJunit.class);
	
	@Resource
	private UserService userService;
	
	@Test
	public void testUser() {
		User user = userService.getUserById("");
		logger.info(JSON.toJSONString(user));
		System.out.println("----》》》》》》》》》》》》》》》》");
	}
	


}
