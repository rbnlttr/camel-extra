# How to add Camel-extra maven repo to your pom.xml #

You will need to add Camel-extra maven repository into your pom.xml file:
```
<repository>
  <id>camel-extra-release</id>
  <name>Camel Extra Maven repository of releases</name>
  <url>http://camel-extra.googlecode.com/svn/maven2/releases</url>
</repository>
```

Then add a dependency for a component that required by your project.
For instance adding **camel-esper** component to the dependency list:
```
<dependency>
  <groupId>org.apache.camel.extra</groupId>
  <artifactId>camel-esper</artifactId>
  <version>1.0</version>
</dependency>
```

Similarly for other components such as **camel-exist** and **camel-hibernate**.