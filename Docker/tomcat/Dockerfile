FROM tomcat:8.0-jre8
ADD target/ecom.war /usr/local/tomcat/webapps
ENV JPDA_ADDRESS 18000
ENV JPDA_TRANSPORT=dt_socket
EXPOSE 8080
EXPOSE 18000
CMD ["catalina.sh", "jpda", "run"]