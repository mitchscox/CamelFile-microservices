package org.ostf.CamelFileTransmitter;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CamelFileTransmitterFileRoutes extends RouteBuilder {
    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLoggingProcessingComponent loggingComponent;

    @Override
    public void configure() throws Exception {
        // enrichment time
        // transmit on a queue
        //Processing
        // log
        from("file:files/input")
                .log("Moving file: ${body}" )
                .to("activemq:CFT-queue")
                .to("file:files/output");
        /*
        from("timer:CFT-timer")
                .log("${body}")
                .transform().constant("Time now is : " + LocalDateTime.now())
                .bean("getCurrentTimeBean")
                .log("${body}")
                .bean(loggingComponent)
                .to("log:CFT-timer");
        */
                }
}

@Component
class GetCurrentTimeBean{
    public String getCurrentTimeBean(){
        return "TIME IS NOW " + LocalDateTime.now();
    }
}

@Component
class SimpleLoggingProcessingComponent{
    private final Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);

    public void process (String message)
    {
        logger.info("Simple logger {}", message);
    }
}