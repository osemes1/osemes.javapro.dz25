import org.junit.platform.engine.discovery.ClassNameFilter;
import org.junit.platform.engine.discovery.PackageNameFilter;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

public class ProjectTestRunner {

    public static void main(String[] args) {
        // Run the test scenarios
        runTestOnClassName("SimpleMathLibraryTest");
        runTestOnClass(SimpleMathLibraryTest.class);
        runTestsByClassNames("SimpleMathLibraryTest");
        runTestsByClasses(SimpleMathLibraryTest.class);
        runTestsByPackage("com.example.tests");
    }

    public static void runTestOnClassName(String className) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .filters(ClassNameFilter.includeClassNamePatterns(className))
                .build();
        runTests(request);
    }

    public static void runTestOnClass(Class<?> testClass) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .filters(ClassNameFilter.includeClassNamePatterns(testClass.getName()))
                .build();
        runTests(request);
    }

    public static void runTestsByClassNames(String... classNames) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .filters(ClassNameFilter.includeClassNamePatterns(classNames))
                .build();
        runTests(request);
    }

    public static void runTestsByClasses(Class<?>... testClasses) {
        String[] classNames = new String[testClasses.length];
        for (int i = 0; i < testClasses.length; i++) {
            classNames[i] = testClasses[i].getName();
        }
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .filters(ClassNameFilter.includeClassNamePatterns(classNames))
                .build();
        runTests(request);
    }

    public static void runTestsByPackage(String packageName) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .filters(PackageNameFilter.includePackageNames(packageName))
                .build();
        runTests(request);
    }

    private static void runTests(LauncherDiscoveryRequest request) {
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
        listener.getSummary().printTo(new PrintWriter(System.out));
    }
}
