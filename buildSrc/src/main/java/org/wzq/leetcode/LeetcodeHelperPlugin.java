package org.wzq.leetcode;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class LeetcodeHelperPlugin implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        target.afterEvaluate(project -> {
            System.out.println("leetcode plugin");
            Fun.sayHello();
        });
    }
}
