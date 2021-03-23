package org.acme;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieConsumer {

    private final Logger logger = Logger.getLogger(MovieConsumer.class);

    @Incoming("movies-in")
    public void receive(Record<String, Movie> record) {
        logger.infof("Got a movie: %s - %s", record.key(), record.value());
    }
//    @Incoming("movies-in")
//    public void receive(Record<String, String> record) {
//        logger.infof("Got a movie: %s - %s", record.key(), record.value());
//    }
}