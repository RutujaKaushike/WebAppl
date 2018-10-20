package com.test.db;

import com.db.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;

public class ConnectionManagerTest {

	@Test
	public void shouldGetConnection(){
		ConnectionManager connectionManager= new ConnectionManager();
		Assert.assertNotNull(connectionManager.getConnection());
	}
}
