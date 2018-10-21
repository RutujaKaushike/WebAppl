package com.test.db;

import com.db.DbService;
import com.restaurant.Restaurant;
import junit.framework.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class BankingServiceTest {

	@Test
	public void shouldInsertData() throws SQLException {
		DbService bankingService = new DbService();
		Integer preCount  = bankingService.getCount();
		Restaurant rest = new Restaurant("radhika");
		bankingService.saveAccount(rest);
		Integer postCount = bankingService.getCount() ;
		Assert.assertEquals(preCount+1, postCount, 0);
	}

	/*@Test
	public void shouldReturnCountOfAccounts()
	{
		DbService bankingService = new DbService();
		Assert.assertNotNull(bankingService.getCount());
		//Assert.assertEquals(12, bankingService.getCount(), 0);
	}

	@Test
	public void shouldGetAll()
	{
		DbService bankingService = new DbService();
		List<Account> list = bankingService.getAll();
		Integer size = list.size();
		Integer count= bankingService.getCount();
		Assert.assertEquals(count, size);
	}*/




}
	

