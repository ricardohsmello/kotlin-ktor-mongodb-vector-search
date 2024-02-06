# kotlin-coroutine-ktor-mongodb
# Overview

Welcome to the Fitness Tracker App repository! This application is designed to help users track their fitness activities and progress.

The main objective of this project is to leverage coroutine capabilities with Kotlin, the Kotlin coroutine MongoDB driver, and the Ktor framework while integrating Koin for dependency injection. This aims to demonstrate best practices and efficient utilization of these technologies within a real-world fitness tracking application.

## Built with

- [Ktor](https://ktor.io/)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [mongodb-driver-kotlin-coroutine](https://www.mongodb.com/docs/drivers/kotlin/coroutine/current/)

## Getting Started

Follow the steps below to get the Fitness Tracker App up and running on your local machine.

### Running

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/your-username/fitness-tracker-app.git
    cd fitness-tracker
    ```

2. Start the application using Docker Compose:

    ```bash
    docker-compose up -d
    ```

3. Compile the application jar using Gradle:

   ```bash
   ./gradlew shadowJar
     ```

4. Run the application local or in cluster
    
   ```bash
   java -jar -DMONGO_URI="mongodb://localhost:27017/fitness/" -DMONGO_DATABASE="discover" build/libs
   ```

### Swagger UI

To explore the API documentation and interact with the Fitness Tracker App, you can use Swagger. Open your web browser and navigate to:

 http://localhost:8080/openapi/
 
 

![OpenAPI](https://i.ibb.co/kQzksr4/openapi.png)


