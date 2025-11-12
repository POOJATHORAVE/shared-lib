# Use lightweight OpenJDK 17 image
FROM eclipse-temurin:17-jdk-alpine 

WORKDIR /app
COPY App.java .

# Compile the Java program
RUN javac App.java

# Expose port 9090
EXPOSE 9090

# Run the app
CMD ["java", "App"]
