FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD /target/*.jar /app.jar

#定义时区参数
ENV TZ=Asia/Shanghai
#设置时区
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo '$TZ' > /etc/timezone

ENTRYPOINT ["java","-jar","/app.jar"]
