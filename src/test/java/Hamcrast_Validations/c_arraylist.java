package Hamcrast_Validations;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.collections.Maps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
Collections
array - test an array’s elements against an array of matchers
hasEntry, hasKey, hasValue - test a map contains an entry, key or value
hasItem, hasItems - test a collection contains elements
hasItemInArray - test an array contains an element
*/

public class c_arraylist {
	@Test
    public void example() {
		//check if single element is in a collection
		List<String> collection = Lists.newArrayList("ab", "cd", "ef");
		assertThat(collection, hasItem("cd"));
		assertThat(collection, not(hasItem("zz")));
		
		//check if multiple elements are in a collection
		List<String> collection1 = Lists.newArrayList("ab", "cd", "ef");
		assertThat(collection1, hasItems("cd", "ef"));

		//check all elements in a collection
		//– with strict order
		List<String> collection2 = Lists.newArrayList("ab", "cd", "ef");
		assertThat(collection2, contains("ab", "cd", "ef"));
		
		//– with any order
		List<String> collection3 = Lists.newArrayList("ab", "cd", "ef");
		assertThat(collection3, containsInAnyOrder("cd", "ab", "ef"));
		
		//check if collection is empty
		List<String> collection4 = Lists.newArrayList();
		assertThat(collection4, empty());
		
		//check if array is empty
		String[] array = new String[] { "ab" };
		assertThat(array, not(emptyArray()));
		
		//check if Map is empty
		Map<String, String> collection5 = Maps.newHashMap();
		assertThat(collection5, equalTo(Collections.EMPTY_MAP));
		
		//check size of a collection
		List<String> collection6 = Lists.newArrayList("ab", "cd", "ef");
		assertThat(collection6, hasSize(3));

		//check condition on every item
		List<Integer> collection7 = Lists.newArrayList(15, 20, 25, 30);
		assertThat(collection7, everyItem(greaterThan(10)));
		
    }
	
	@Test
	public void givenMapAndKey_whenKeyFoundInMap_thenCorrect() {
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("blogname", "baeldung");
	    assertThat(map, hasKey("blogname"));
	}
	
	@Test
	public void givenMapAndValue_whenValueFoundInMap_thenCorrect() {
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("blogname", "baeldung");
	    assertThat(map, hasValue("baeldung"));
	}
	
	@Test
	public void givenMapAndEntry_whenEntryFoundInMap_thenCorrect() {
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("blogname", "baeldung");
	    assertThat(map, hasEntry("blogname", "baeldung"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
