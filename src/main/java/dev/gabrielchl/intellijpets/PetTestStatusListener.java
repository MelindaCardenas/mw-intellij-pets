package dev.gabrielchl.intellijpets;
import com.intellij.execution.testframework.AbstractTestProxy;
import com.intellij.execution.testframework.TestStatusListener;

import java.util.ArrayList;


public class PetTestStatusListener extends TestStatusListener {
    private static ArrayList<Runnable> callbacks = new ArrayList<Runnable>();
    public void testSuiteFinished(AbstractTestProxy root) {
        if (root.isPassed()) {
            for (Runnable runnable: callbacks) {
                runnable.run();
            }
        }
    }

    public static void registerCallback(Runnable runnable) {
        callbacks.add(runnable);
    }

}