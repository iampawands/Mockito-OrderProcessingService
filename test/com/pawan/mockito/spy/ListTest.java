package com.pawan.mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListTest {
	@Spy
	List<String> list = new ArrayList<String>();
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void listTestCase() {
//		when(list.get(2)).thenReturn("Hello"); --> this will throw array out of bound exception because spy will call all method of
//		mock object. So @Mock will work fine. But if want to use @Spy then use below doReturn type of stubbing
		doReturn("Hello").when(list).get(2);
		String result = list.get(2);
		assertEquals("Hello", result);
	}
}
