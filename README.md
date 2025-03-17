**********************************************************************************************************

************************** For Local Run with Docker Compose ********************************************
    *.) if you are using eclise, right click on each project run maven build.. , and set the goal to "clean install".
    *.) then run "docker-compose --build" command.
    *.) Run a sample post api from postman or swagger and see whether a report is generated iside the "Container", such as
    {
      "reportName": "test_session_report _1",
      "reportType": "sessions",
      "status": "in_progress",
      "fileLink": "http://testserver/report/test_session_report _1.csv"
    }
  *.) Open the docker desktop, go inside the container and see the report is genrated (filewrite/reports) inside the filewriter container.
  *.) Go to H2 console and check report data is available.


**********************************************************************************************************

******************************* For Local Run without Docker *********************************************

  *.) Change the both application.yml of two service to different name and change local-application.yml to application.yml
  *.) Go to KafkaReportServiceProducerConfig.java class in Report-Service and comment the line which is redirecting to kafka,
    comment-out configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092"); and uncomment configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
  *.) if you are using eclise, right click on each project run maven build.. , and set the goal to "clean install".
  *.) after building the two project run go to the swagger and check the get and post api's are available. http://localhost:8080/swagger-ui.html
  *.) start zoo keeper by cmd using the command : "bin\windows\zookeeper-server-start.bat config\zookeeper.properties". NOTE: install/download kafka and go inside the folder
  *.) start kafka by cmd using the command : "bin\windows\kafka-server-start.bat config\server.properties"
  *.) to see the kafka-logs go inside the kafka/bin/windows and run in cmd : "kafka-console-consumer --topic report-requests --bootstrap-server localhost:9092 --from-beginning"
  *.) Run a sample post api from postman or swagger and see whether a report is generated , such as
    {
      "reportName": "test_session_report _1",
      "reportType": "sessions",
      "status": "in_progress",
      "fileLink": "http://testserver/report/test_session_report _1.csv"
    }
  *.) Go to H2 console and check report data is available.

 
