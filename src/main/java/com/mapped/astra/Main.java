package com.mapped.astra;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.janusgraph.core.JanusGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Iterator;

@SpringBootApplication(scanBasePackages = "com.mapped.astra")
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Autowired
    private JanusGraph janusGraph;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void startApplication(){

        LOGGER.info("Application is started");

        GraphTraversalSource g = janusGraph.traversal();
        janusGraph.addVertex().property("name","jim");
        janusGraph.tx().commit();
        //g.addV("employee").with("name","jim").next();
        Iterator<Vertex> itr = g.V();
        System.out.println("hasNext : " + itr.hasNext());
        while(itr.hasNext()){
          System.out.println(itr.next());
        }
        LOGGER.info("The test case is finished");

    }

}
