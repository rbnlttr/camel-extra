This a simple demo showing how to integrate the Camel Esper component with ActiveMQ

## How to run ##

Grab the [source code](http://code.google.com/p/camel-extra/source/checkout) and [build it](Building.md).

Then change directory into the Esper demo

```
cd examples/camel-esper-demo
```

1) in one shell just type:

```
mvn camel:run
```

This starts a java process with an embedded ActiveMQ message broker and a Camel route.
This Camel route receives a flow of events coming from a JMS queue injecting them into a complex event processing flow  based on a couple of Camel Esper components.

2) On another shell just type:

```
mvn exec:java
```

This starts a JMS producer that sends a stream of events to the queue hosted by the embedded message broker above.

This demo is based on [an Exper tutorial](http://esper.codehaus.org/tutorials/tutorial/feedmonitor_casestudy.html),  look there for an exact meaning of the two Esper scripts in the demo