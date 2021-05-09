package org.wzq.leetcode

import org.gradle.api.Plugin
import org.gradle.api.Project

class LeetcodePlugin implements Plugin<Project> {
    public static final String TASK_GROUP = "leetcode";

    @Override
    void apply(Project target) {
        target.task("sayHello") {
            println("hello leetcode")
        }.setGroup(TASK_GROUP)

        target.dependencies {
            implementation group: 'org.apache.commons', name: 'commons-lang3', version: '3.3'
        }
    }
}
