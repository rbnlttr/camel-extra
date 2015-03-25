The Camel Extra project uses [Maven](http://maven.apache.org/) as its build tool. If you don't fancy using Maven you can use your IDE directly or [Download](http://code.google.com/p/camel-extra/downloads/list) a distribution.

## Prequisites ##

  * Download and [install Maven](http://maven.apache.org/start/install.htm)
  * Get the latest [Source](http://code.google.com/p/camel-extra/source/checkout)

### A normal build ###

```
mvn install
```

### Doing a Quick Build ###

The following avoids running all the unit test cases

```
mvn -Dtest=false install
```

### Using an IDE ###

If you prefer to use an IDE then you can auto-generate the IDE's project files using maven plugins. e.g.

```
mvn eclipse:eclipse
```

or if you have an older version of IDEA then try this (IDEA 7.0 can open pom.xml files directly)

```
mvn idea:idea
```


If you have not already done so, you will need to make Eclipse aware of the Maven repository so that it can build everything. In the preferences, go to Java->Build Path->Classpath and define a new Classpath Variable named **M2\_REPO** that points to your local Maven repository

  * on unix its  _~/.m2/repository_
  * on windows its  _c:\Documents and Settings\_

&lt;user&gt;

\.m2\repository

### Releasing ###

See the ReleaseGuide for more details