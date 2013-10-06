package com.yahoo.cafes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.yahoo.cafes.models.CafeTest;
import com.yahoo.cafes.models.CommentTest;
import com.yahoo.cafes.models.LocationTest;
import com.yahoo.cafes.models.MenuItemTest;
import com.yahoo.cafes.models.MenuTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CommentTest.class, 
	MenuItemTest.class,
	MenuTest.class,
	LocationTest.class,
	CafeTest.class
	})
public class CafeTestSuite {

}