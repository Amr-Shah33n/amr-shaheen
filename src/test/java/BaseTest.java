import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.moneyapp.DriverManager;

public abstract class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @BeforeEach
    public void setup(TestInfo testInfo) {
        LOGGER.info("Starting test: {}", testInfo.getDisplayName());
        DriverManager.driver.get();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        LOGGER.info("Ending test: {}", testInfo.getDisplayName());
        DriverManager.tearDown();
    }
}
