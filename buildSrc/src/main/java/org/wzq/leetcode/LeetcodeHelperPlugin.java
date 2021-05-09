package org.wzq.leetcode;

import com.ciaoshen.leetcode.helper.ProblemBuilder;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class LeetcodeHelperPlugin implements Plugin<Project> {

    public static final String TASK_GROUP = "leetcode";

    @Override
    public void apply(Project target) {
        target.task("sayHello", task -> {
            task.doLast(it ->
                Fun.sayHello()
            );
        }).setGroup(TASK_GROUP);

        target.getExtensions().create("problem", Problem.class);

        target.afterEvaluate(t -> {
            Problem problem = (Problem) target.getExtensions().getByName("problem");
            System.out.println(problem);
            System.out.println(target.getRootDir());
        });

        target.task("create111", task -> {
            task.doLast(t -> {
                Problem problem = (Problem) target.getExtensions().getByName("problem");
                String[] args = new String[]{
                    target.getRootDir().toString(), problem.name,
                    problem.pck, problem.util, problem.members
                };
                ProblemBuilder builder = new ProblemBuilder(args);
                builder.writeTemplates();
            });
        });
    }

    Properties loadProblemProperties(Project project) {
        Properties problemProperties = new Properties();
        String path = project.absoluteProjectPath("problem.properties");
        try {
            problemProperties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return problemProperties;
    }
}
