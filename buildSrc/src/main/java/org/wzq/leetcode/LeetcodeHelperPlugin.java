package org.wzq.leetcode;

import com.ciaoshen.leetcode.helper.ProblemBuilder;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.dsl.DependencyHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


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

        target.getExtensions().configure("problem", object -> {
            Problem problem = (Problem) object;
            problemLoad(problem);
        });

        target.afterEvaluate(t -> {
            Problem problem = (Problem) target.getExtensions().getByName("problem");
            System.out.println(problem);
        });

        addDependencies(target);

        target.task("create", task -> {
            task.doLast(t -> {
                Problem problem = (Problem) target.getExtensions().getByName("problem");
                String[] args = new String[]{
                    target.getRootDir().toString(), problem.name,
                    problem.pck, problem.util, problem.members
                };
                ProblemBuilder builder = new ProblemBuilder(args);

                String subPath = problem.pck.replace('.', '/');
                File file = new File("src/main/java" + '/' + subPath + '/' + problem.name);
                if (!file.exists()) {
                    builder.writeTemplates();
                } else {
                    System.out.println("exits!");
                }

            });
        })
        .setGroup(TASK_GROUP);
    }

    private void problemLoad(Problem problem) {
        Properties problemProperties = new Properties();
        try {
            problemProperties.load(new FileInputStream("problem.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        problem.name = problemProperties.getProperty("problem.name");
        problem.pck = problemProperties.getProperty("problem.pck");
        problem.members = problemProperties.getProperty("problem.members");
        problem.util = problemProperties.getProperty("problem.util");
    }

    void generate(Project project) {
        Problem problem = (Problem) project.getExtensions().getByName("problem");
        String[] args = new String[]{
            project.getRootDir().toString(), problem.name,
            problem.pck, problem.util, problem.members
        };
        ProblemBuilder builder = new ProblemBuilder(args);

        String subPath = problem.pck.replace('.', '/');
        File file = new File("src" + '/' + subPath + '/' + problem.name);
        if (!file.exists()) {
            builder.writeTemplates();
        } else {
            System.out.println("exits!");
            Scanner sc = new Scanner(System.in);
            while(true) {
                String s = sc.nextLine();
                if (s.equals("y")) {
                    builder.writeTemplates();
                    break;
                } else if (s.equals("n")) {
                    break;
                }
            }
        }
    }

    void addDependencies(Project project) {
        DependencyHandler dh = project.getDependencies();

        String jarPath = ProblemBuilder.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        dh.add("implementation", project.files(jarPath));

        dh.add("implementation", "org.apache.velocity:velocity-engine-core:2.0");
        dh.add("implementation", "log4j:log4j:1.2.17");
        dh.add("implementation", "org.slf4j:slf4j-api:1.7.25");
        dh.add("implementation", "org.slf4j:slf4j-log4j12:1.7.25");
        dh.add("implementation", "org.apache.commons:commons-lang3:3.3");

        dh.add("testImplementation", "junit:junit:4.10");
        dh.add("testImplementation", "org.hamcrest:java-hamcrest:2.0.0.0");
    }
}
