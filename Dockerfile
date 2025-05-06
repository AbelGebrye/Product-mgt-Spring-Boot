# Step 1: Build the app with Maven
FROM maven:3.8.4-openjdk-17-slim as build

# Set the working directory to /app
WORKDIR /app

# Set JVM memory options
ENV JAVA_OPTS="-Xmx2g -Xms1g"

# Copy the pom.xml and download dependencies to cache them
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the source code and build the app
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Create the production image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

RUN mvn clean install

# Copy the JAR file from the build stage
COPY --from=build /app/target/thymeleafdemo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot app will run on
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
