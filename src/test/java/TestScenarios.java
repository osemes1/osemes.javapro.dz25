import org.junit.platform.engine.discovery.ClassNameFilter;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;


public class TestScenarios {
    public static LauncherDiscoveryRequest getTestScenarios() {
        return LauncherDiscoveryRequestBuilder.request()
                .filters(
                        ClassNameFilter.includeClassNamePatterns(".*SimpleMathLibraryTest")
                )
                .build();
    }
}