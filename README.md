# puls-tomcat-valve
Tomcat valve vs java filter - sample code to use tomcat valve to intercept http request
Solution Design - Tomcat Valve vs Filters

Developers love simulators. We develop them; use them just to make Dev testing easier. More often these simulators become the de-facto standard during testing purpose and Dev just pass on them to QA for easy testing.
But this approach always carries a risk of packaging simulation code to production. 
During the SDLC life cycle, it’s a common scenario to see code written for Dev testing, eventually gets packaged into shippable code and deployed in production.

Below is the illustration of one of the use case. 

Consider following use-cases for Rest/WEB operation for Dev testing:-
1. You need to log entire http request
2. By pass any rest operation and give false success.
3. Block rest operation for a particular user based on particular IP address.

Comment on the article if this solution popped up in your mind :)

Obvious approach which comes to Java developers is to use Servlet Filters.  
But it's conveniently forgotten that Filter configuration leads an entry to web.xml of the war which is the production shippable code. So there is a risk  the change which  was done to support Dev/QA testing lands up into production.
Is it a good strategy  to change in shippable  code just to support Dev testing ?


Proposed Solution
An effective way to tackle the above problem is to use tomcat valve. This technology provides you the mechanism to intercept http request at container level and fulfill your use case. Moreover usually tomcat configuration files such as server.xml, scripts are different for production and dev. environments. Hence there is no risk that your simulation code required for Dev environment will land up into production.  
Simple entry in server.xml : <Valve className="com.kronos.auth.tomcat.AuthnTomcatValve" />  and placing the jar inside tomcat/libs will suffice the purpose.

Checkout Sample tomcat valve code from GitHub Repo







 

