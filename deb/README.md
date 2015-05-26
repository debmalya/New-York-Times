

Solution:
1. First I retrieve categories in New York Times. By hitting URL http://api.nytimes.com/svc/news/v3/content/section-list.json using API key,

2. Next I retrieved details of the selected category. This is hitting another URL and parsing JSON.

3. Categories with are saved in MongoDB (Please refer ApplicationConfigurationTest.java methods testCreateRetrieveObject,printAll)

4. MonogDB can be configured in location  src\main\resources\db.properties

5. Execution
run mvn clean package from command prompt. (e.g. C:\deb>mvn clean package)

run mvn jetty:run from command prompt (e.g. C:\deb>mvn jetty:run)

By default it will run in port 8082. We will get output like below
[INFO] Started SelectChannelConnector@0.0.0.0:8082
[INFO] Started Jetty Server
[INFO] Starting scanner at interval of 10 seconds.

Then try following URL from the browser.
http://localhost:8082/deb/

If port 8082 is occupied, change the value in pom.xml for the jetty plugin.