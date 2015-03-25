This project contains a number of extension components for the [Apache Camel integration framework](http://activemq.apache.org/camel/) which due to GPL/LGPL licensing [cannot be hosted at Apache](http://www.apache.org/legal/3party.html).

## Supported Components ##

  * [Esper](http://camel.apache.org/esper.html) for working with the [Esper](http://esper.codehaus.org/) Event Stream Processing library
  * [Hibernate](http://camel.apache.org/hibernate.html) for working with the [Hibernate](http://hibernate.org/) object relational mapping library
  * An [eXist database](http://exist.sourceforge.net/) component for marshalling XML into the exist db and querying it.
  * [Smooks](http://camel.apache.org/smooks.html) for working with the [Smooks](http://milyn.codehaus.org/Smooks) library for EDI parsing.
  * [camel-jboss](http://camel.apache.org/camel-jboss.html) for running Camel inside JBoss Application Server.

## Examples ##

  * [EsperDemo](EsperDemo.md) for an example of how to work with Camel, [Esper](http://esper.codehaus.org/) and [ActiveMQ](http://activemq.apache.org)

## Speculative Components ##

  * [CamelSpit](CamelSpit.md) an Eclipse editor for a text-based Camel DSL with syntax completion, outline view and wacky error reporting.

## Getting Started ##

To get started add the Camel Extra [maven repository](MavenRepo.md) to your project as [described here](AddingMavenRepo.md)