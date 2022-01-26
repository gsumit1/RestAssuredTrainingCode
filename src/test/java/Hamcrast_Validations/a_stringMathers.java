package Hamcrast_Validations;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/*
Text
equalToIgnoringCase - test string equality ignoring case
equalToIgnoringWhiteSpace - test string equality ignoring differences in runs of whitespace
containsString, endsWith, startsWith - test string matching
*/

public class a_stringMathers {
	
	    @Test //Type Safe
	    public void example0() {
	        String a = "foo";
	        //Integer b = "FOO";
	        //assertThat(a, equalToIgnoringCase(b));
	    }
	
	    @Test
	    public void example1() {
	        String a = "foo";
	        String b = "FOO";
	        assertThat(a, equalToIgnoringCase(b));
	    }
	    
	    @Test
	    public void example2() {
	        String a = "foo";
	        String b = "FOO";
	        assertThat(a, equalTo(b));
	    }
		    
	    @Test
	    public void example3() {
	        String a = "foo";
	        String b = "FOO";
	        assertThat(a, is(b));
	    }
	    
	    @Test
	    public void example4() {
	    	assertThat("test", instanceOf(String.class));
	    }
	    
	    @Test
	    public void example5() {
	    	assertThat("test", containsString("est"));
	    }
	    	    
	    @Test
	    public void example6() {
	    	assertThat("test", endsWith("st"));
	    }
	    
	    @Test
	    public void example7() {
	    	assertThat("test", startsWith ("te"));
	    }
	    
	    @SuppressWarnings("deprecation")
		@Test
	    public void givenString_whenEmpty_thenCorrect() {
	        String str = "";
	        assertThat(str, isEmptyString());
	    }
	    
	    @SuppressWarnings("deprecation")
		@Test
	    public void givenString_whenEmptyOrNull_thenCorrect() {
	        String str = null;
	        assertThat(str, isEmptyOrNullString());
	    }  
	    
}
