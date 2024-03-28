package herokuapp_smoketest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    _01_SmokeTest_Post.class,
    _02_SmokeTest_Get.class,
    _03_SmokeTest_Put.class,
    _04_SmokeTest_Patch.class,
    _05_SmokeTest_Delete.class,
    _06_SmokeTest_Negative.class
})

public class Runner {
}
