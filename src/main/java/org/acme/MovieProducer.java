package org.acme;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MovieProducer {

  @Inject
  @Channel("movies-out")
  Emitter<Record<String, Movie>> emitter;
//  @Inject
//  @Channel("movies-out")
//  Emitter<Record<String, String>> emitter;

  @BackpressureSupport(BackpressureKind.FULL)
  public void sendMovieToKafka(Movie movie) {
//    Multi.createFrom()
//        .ticks()
//        .every(Duration.ofMillis(20l))
//        .onSubscribe()
//        .invoke(sub -> System.out.println("Received subscription: " + sub))
//        .onRequest()
//        .invoke(req -> System.out.println("Got a request: " + req))
//        .subscribe()
//        .with(i -> emitter.send(Record.of(movie.year, movie.title)));
    emitter.send(Record.of(movie.year, movie));
//            emitter.send(Record.of(movie.year, movie.title));
  }
}
