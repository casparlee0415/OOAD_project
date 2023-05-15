FROM tomcat:10.0.27
ADD target/OOAD_project-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]