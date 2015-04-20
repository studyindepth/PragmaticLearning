package concurrency.akka;

import java.io.Serializable;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Actors {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");
        ActorRef greeter = system.actorOf(Props.create(GreetingActor.class), "greeter");
        greeter.tell(new Greeting("Charlie Parker"), ActorRef.noSender());
        greeter.tell("abc", ActorRef.noSender());
    }

}

class Greeting implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public String who;

    public Greeting(String who) {
        this.who = who;
    }
}

class GreetingActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public void onReceive(Object message) throws Exception {
        if (message instanceof Greeting) {
            log.info("Hello " + ((Greeting) message).who);
            System.out.println(message);
        } else {
            System.out.println(message);
        }
    }

}
