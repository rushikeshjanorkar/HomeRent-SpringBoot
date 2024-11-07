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

# Verify Java version (optional)
RUN java -version

# Run Maven build and install dependencies
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install
