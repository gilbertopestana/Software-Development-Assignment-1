package testcalculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEntry.class, TestStack.class, TestSymbol.class, TestType.class })

/**
 * Test all tests on the package <code>testcalculator</code>
 * @author Gilberto Pestana
 */
public class AllTests {

}
