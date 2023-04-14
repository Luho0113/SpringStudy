package org.zerock.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	// �����ͼҽ� �׽�Ʈ

	@Inject
	private DataSource ds;

	@Test
	public void testConnection() throws Exception {

		Connection conn;

		try {
			conn = ds.getConnection();
			System.out.println(conn);
			System.out.println("����!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����!");
		}
	}
}
