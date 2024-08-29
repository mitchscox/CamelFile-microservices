package org.ostf.CamelFileReceiver;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelFileReceiverRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception{
        from("activemq:CFT-queue")
                .to("log:Received message ${body} ");
    }
}
