# Skeleton of Backing Microservice Application
## 
#- ***config-server-repo*** #
Contient les fichiers *.properties d'externalisation de la configuration des microservices.
Contient: 
	eureka-server.properties
	zuul-distributed-tracing-server.properties
	mon-microservice-x.properties

#- ***config-server*** #
Server de configuration *Spring Cloud Config*.
Dependencies: Config Server, Spring Cloud sleuth-zipkin, 
bootstrap.properties

#- ***eureka-server*** #
Découvrabilité. Garde un registre de tous les instances de microservices disponible.
Dependencies : Eureka Server, Config Client, Spring Cloud sleuth-zipkin, 
bootstrap.properties

#- ***zuul-distributed-tracing-server*** #
Api Gateway : C'est le Point d'entré unique de notre application.
Dependencies: Zuul, Eureka Discovery Client, Config Client, Security, Spring Cloud sleuth-zipkin, 
bootstrap.properties

#- ***zipkin-server*** #
Tracabilité de toutes les requêtes
Dependencies: 

#- ***spring-admin*** #
Dependencies: Spring boot admin (Server), Actuator, Eureka Discovery, 

#- ***mon-microservice-x*** #
un microservice x de notre application doit avoir les dépendances suivantes.
	Dependencies : Config Client, Actuator, Eureka Discovery Client, Ribbon (équilibreur de charge), Spring Cloud sleuth-zipkin, 
	renomer application.properties en bootstrap.properties
# solidapp-backend-skeleton
# SolidApp Microservice Skeleton for quick start
