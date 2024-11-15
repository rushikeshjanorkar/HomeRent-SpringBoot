# Use OpenJDK 19 base image
FROM openjdk:19-jdk-slim

# Set environment variables for Java
ENV JAVA_HOME=/usr/lib/jvm/java-19-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Set the working directory
WORKDIR /app

# Copy project files into the container
COPY . /app

# Ensure Maven wrapper is executable
RUN chmod +x ./mvnw

# Verify Java version
RUN java -version

# Run Maven to install dependencies and clean up (Skip tests during the build process)
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Expose port (if your application is a web service)
EXPOSE 8080

# Run the application (if it's a Spring Boot application)
CMD ["./mvnw", "spring-boot:run"]
