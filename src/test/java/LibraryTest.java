import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

public class LibraryTest {
	private static Logger log = Logger.getLogger(Library.class);
    @Test 
    public void testSomeLibraryMethod() {
 	   String log4jConfPath = "log4j.properties";
 	   PropertyConfigurator.configure(log4jConfPath);
        Library classUnderTest = new Library();
    	log.info("this is test ");
    	log.debug("this is test ");
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}
