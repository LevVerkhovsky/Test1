package com.sample.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sample.util.UserUtils;

public class UserUtilsTest {
    @Test
    public void testConvertEmptyListToJSON() {
    	String expected = "{}";
        String result = UserUtils.convertListToJSON(new ArrayList<String>());
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void testConvertNonEmptyListToJSON() {
    	String expected = "{{ username: \"username1\"},{ username: \"username2\"}}";
    	List<String> list = new ArrayList<String>();
    	list.add("username1");
    	list.add("username2");
        String result = UserUtils.convertListToJSON(list);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void testConvertStatusToJSONFalse() {
    	String expected = "{ status: \"Error occurred\" }";
        String result = UserUtils.convertStatusToJSON(false);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void testConvertStatusToJSONTrue() {
    	String expected = "{ status: \"Added successfully\" }";
        String result = UserUtils.convertStatusToJSON(true);
        assertNotNull(result);
        assertEquals(expected, result);
    }
}