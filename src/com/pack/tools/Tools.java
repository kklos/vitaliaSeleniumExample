package com.pack.tools;

import java.util.List;

public class Tools {

	public static boolean stringContainsItemFromList(String inputStr, List<String> items)
	{
	    for(int i =0; i < items.size(); i++)
	    {
	        if(inputStr.contains(items.get(i)))
	        {
	            return true;
	        }
	    }
	    return false;
	}
}
