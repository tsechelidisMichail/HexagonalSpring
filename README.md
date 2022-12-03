# HexagonalSpring
Hexagonal web application with spring.

For using Grpc Controllers, maven clean install , and generated files are going to be created to resolve type errors.

For kafka: it doesn't reflect the nature of withdraw, it is just an example.
For running kafka(app can still run without kafka) create in the machine the enviroment for it with:
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties
.\bin\windows\kafka-topics.bat --create --topic withdraw-kafka --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
