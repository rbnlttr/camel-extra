# Introduction #

| **06jan11** I just noticed Claus clearing out all the old bug reports as wontfix - I don't think I'll be getting back to this project at any point in the future. For interested parties, the Xtext DSL kit has really advanced, so you would be well recommended to rewrite from scratch, rather than re-using any of this stale code.  --oh |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **29jul09** I haven't done anything with this project for a long  while, but hopefully at some point I'll get back to and port all the Xtext goodness to Eclipse Galileo and Camel 2.0. But I would advise non-holding of breath! --oh |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

**Spit** is a really, really early stage piece of research into generating a syntax-completion editor for a text-based (i.e. not XML, not programming language) DSL for Camel. It's called **Spit** because camels do that a lot, and it will probably be your first reaction when you try it out :)

[Screenshots live here!](CamelSpitScreenshots.md)

I started this mainly as a way to learn how [Xtext](http://wiki.eclipse.org/Xtext) works, basing the initial grammar on a [contribution by Vadim Chekan](http://issues.apache.org/activemq/browse/CAMEL-1046). I ended up departing from that grammar a bit, mainly driven by some limitations in the way I currently know how to drive Xtext.

# Dependencies #

Before you can get going, you will need to have Eclipse and Xtext. I've used Eclipse 3.3.2 for this, but you should be ok with 3.4.1 also. I haven't tried it yet.

Get Eclipse 3.3.2 [here](http://www.eclipse.org/europa/), just the Java Developers Version.

The best way to get Xtext, and it's multiple modeling dependencies is to use the Eclipse update manager.

In your IDE, hit ` Help > Software Updates > Find and Install `.

Then ` Search for new features to install `.

Then ` New Remote Site ` and enter the name as `Xtext` and the URL as `http://www.openarchitectureware.org/updatesite/milestone/site.xml` then enter. The dialog box will go away, bringing you back to the {{{Update sites to visit}} selection.

Tick the boxes next to `Xtext` and `Europa Discovery Site` and hit `Finish`.

You will be asked to select a mirror for the Europa Discovery Site (aka 3.3.2). There will be some chugging as Eclipse gathers the feature metadata for the sites.

Click the twisty beside the `Xtext` in the `Search Results` box, then click the twisty beside the exposed `openArchitectureWare` category. Below this you should see a feature name with {{{xtext}} in it - select this.

Next, come back up a couple of levels in the `Search Results` box, then click the twisty beside the `Europa Discovery Site` category, so that you see all the sub-categories.

Push the `Select Required` button on the right of the `Search Results` box. This should do all the tedious management of the dependencies for you - you will see some new boxes being ticked. Hopefully all the little red Xs have gone away now.

Push the `Finish` button, and then follow the usual Eclipse update wizard prompts to install.

This is easier than just getting the zips, believe me.

# Build it #

Get the source from SVN at `https://camel-extra.googlecode.com/svn/trunk/ide/eclipse/camel-spit` - there are two Eclipse projects in there. You may either check em out using the SVN command line client, then to a `File > Import` to import the code as existing projects from the filesystem, or if you are using an Eclipse SVN client, just do a `File > Import` as existing projects direct from the repo.

The source should build as is -- I've taken the lazy approach of checking in the generated code for the moment, until such time as there may be regular builds (and that's probably not even necessary to be honest).

# Run it #

Right-click on one of the projects and choose `Run As... > Eclipse Application`. This will spawn a new runtime workbench with the editor embedded. Create a project `File > New > Java Project` for example, and then start editing a DSL file with `File > New > Other... > Xtext DSL Wizards > Spit File` and hack away.


# State of Play #

There's lots to be done
  * error messages are obscure to say the least [Issue 10](http://code.google.com/p/camel-extra/issues/detail?id=10)
  * outline view gets construct with some weird juju I don't understand yet [Issue 9](http://code.google.com/p/camel-extra/issues/detail?id=9)
  * the grammar is rather simple and has some redundancies
  * the editing doesn't look like [CAMEL-1046](http://issues.apache.org/activemq/browse/CAMEL-1046) at the moment [Issue 13](http://code.google.com/p/camel-extra/issues/detail?id=13)
  * the icons and the names of wizards are still the autogenerated defaults [Issue 11](http://code.google.com/p/camel-extra/issues/detail?id=11)
  * there's no code/model generation framework yet [Issue 12](http://code.google.com/p/camel-extra/issues/detail?id=12)

# Whats The Future #

I think that from a tools perspective having a canonical model of the Camel routes is the core element for supporting a diversity of approaches. That model is the core connected graph of objects that lives in memory when Camel has loaded a route. It's also that piece of Spring XML that is a JAXB serialization of the model. If there is a way to keep a hidden representation of this model in your Eclipse project, then there should be little trouble in traversing from XML to Java to Scala to Spit, should you fancy it.

For the graphical representation, we'll need to add some stuff like basic layout and preference data. This is one of the few things that a Camel cannot eat, but it'll be necessary to stop users blowing a gasket as they tweak their diagrams/data layouts for
the umpteenth time.