package org.wzq.leetcode;

import org.gradle.api.Plugin;
import org.gradle.api.Project;


public class LeetcodeHelperPlugin implements Plugin<Project> {

    public static final String TASK_GROUP = "leetcode";

    @Override
    public void apply(Project target) {
        target.task("sayHello", task -> {
            task.doLast(it ->
                Fun.sayHello()
            );
        }).setGroup(TASK_GROUP);

    }
}
