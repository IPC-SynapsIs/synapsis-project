package org.ipc.synapsis.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = {"org.ipc.synapsis.project.dao"})
public class ProjectServerClass {
    public static void main(final String[] args) {
        SpringApplication.run(ProjectServerClass.class, args);
    }

}