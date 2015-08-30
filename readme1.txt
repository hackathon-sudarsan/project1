software \\113.128.166.227\c$\downloads

\\113.128.161.200\d$
\\113.128.161.205\d$
\\166.44.165.229\d$
proxy.ebiz.verizon.com

113.128.163.236 mine
113.128.161.205 Nadeem
113.128.161.200 jaya


https://vdsicitrix.verizon.com
=================================
https://github.com

https://github.com/hackathon-sudarsan/project1.git
user	hackathon-sudarsan

email   sudarsan.x.james@verizon.com

pass    codered1



https://travis-ci.org

http://docs.travis-ci.com/user/deployment/cloudfoundry/
https://pivotallms.biglms.com/courses/PivotalAcademy/PCF100/VWZP/about



https://run.pivotal.io

email   sudarsan.x.james@verizon.com

pass    codered1






Instance name	codred-DB-instance - deleted

Instance name	codered-mysql

hostname	us-cdbr-iron-east-02.cleardb.net
jdbcUrl		jdbc:mysql://us-cdbr-iron-east-02.cleardb.net/ad_43f635f72750b54?user=bfe8e3698cba7f&password=ba6201f1
name		ad_43f635f72750b54
password	ba6201f1
port		3306
uri		mysql://bfe8e3698cba7f:ba6201f1@us-cdbr-iron-east-02.cleardb.net:3306/ad_43f635f72750b54?reconnect=true
username	bfe8e3698cba7f



Instance name	codered-flash

===============================
mvn settings.xml proxy

 <proxies>
   <proxy>
      <id>vdsi-proxy</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.ebiz.verizon.com</host>
      <port>80</port>
      <username>VDSI/vzid</username>
      <password>somepassword</password>
      <nonProxyHosts>www.google.com|*.example.com</nonProxyHosts>
    </proxy>
  </proxies>

===============================

Windows

I usually only need to set:
set http_proxy=http://VDSI/v709683:MScross1@proxy.ebiz.verizon.com:80
set https_proxy=http://VDSI/v709683:MScross1@proxy.ebiz.verizon.com:80
===============================
etc/hosts

192.30.252.128		github.com

==
git proxy

c:/usr/admin/.git.config

[http] 		
proxy = http://VDSI/v709683:MScross1@proxy.ebiz.verizon.com:80
[https] 	
proxy = http://VDSI/v709683:MScross1@proxy.ebiz.verizon.com:80

===============================
travis.yml

 language: java
 install: mvn install -DskipTest=true
 sudo: required
 sudo: true
  
deploy:
 edge: true
 provider: cloudfoundry
 username: sudarsan.x.james@verizon.com
 password: codered1
 api: https://api.run.pivotal.io
 organization: CodeRed
 space: development

==
manifest.yml

---
applications: 
 - name: CodeRed
   memory: 512M 
   host: CodeRed-host
   path: target/codered.war

===============================
222.175.59.218 	9797
193.179.1.114 	8080
200.192.252.130 	8080
200.192.211.6 	8080 
183.89.130.116 	8080
219.238.54.241 	3128
203.114.104.82 	8080
188.129.125.238 	8080
190.52.255.28 	8080
180.250.88.173 	3128
171.96.152.89 	8080
220.198.106.249 	9999
