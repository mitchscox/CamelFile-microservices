package org.ostf.CamelFileTransmitter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderRouter extends RouteBuilder {
    @Override
            public void configure() throws Exception{
           /* from("timer:active-mq-timer?period=1000")
                    .transform().constant("Timer message for ActiveMQ")
                    .to("activemq:CFT-queue");

            */
    }


}
