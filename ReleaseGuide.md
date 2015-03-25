## Prerequisites ##

You need to edit your ~/.m2/settings.xml to add the camel-extra servers. So your XML should look something like...

```
<?xml version="1.0"?>
<settings>
	<servers>
		<server>
			<id>camel-extra-release</id>
			<username>MY_GOOGLE_ACCOUNT_NAME</username>
			<password>MY_GOOGLE_PASSWORD</password>
		</server>
		<server>
			<id>camel-extra-snapshot</id>
			<username>MY_GOOGLE_ACCOUNT_NAME</username>
			<password>MY_GOOGLE_PASSWORD</password>
		</server>
...
```

If you are a committer you should then be able to submit a snapshot via

```
mvn deploy
```

### Performing a release ###

Try use the normal maven release plugin...

```
mvn -Dusername=MY_GOOGLE_ACCOUNT_NAME release:prepare
mvn -Dusername=MY_GOOGLE_ACCOUNT_NAME release:perform
```