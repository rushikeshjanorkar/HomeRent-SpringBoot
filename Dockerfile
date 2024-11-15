# Set base image
FROM openjdk:19

# Set working directory
WORKDIR /app

# Copy files
COPY . /app

# Set JAVA_HOME (if needed)
ENV JAVA_HOME=/usr/lib/jvm/java-19-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Install Maven if not using Maven wrapper
RUN apt-get update && apt-get install -y maven

# Run Maven commands (skip tests)
RUN mvn -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install
