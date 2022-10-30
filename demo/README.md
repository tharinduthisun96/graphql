
"import graphql.scalars.java.JavaPrimitives;" Error

I have been using java 8. I received an error with dependency with of scalars
https://github.com/graphql-java/graphql-java-extended-scalars

implementation 'com.graphql-java:graphql-java-extended-scalars:19.0'

<dependency>
  <groupId>com.graphql-java</groupId>
  <artifactId>graphql-java-extended-scalars</artifactId>
  <version>19.0</version>
</dependency>


=======================================

There was a flyway error. Which was 

spring.flyway.enabled=false

I used following dependencies for flyway but there was a 

implementation 'org.flywaydb:flyway-core'
implementation 'org.flywaydb:flyway-mysql'
Issue was resolved with 2.6.3
implementation 'org.flywaydb:flyway-core:2.6.3'

Error is 

Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'graphQlRouterFunction' defined in class path resource [org/springframework/boot/autoconfigure/graphql/servlet/GraphQlWebMvcAutoConfiguration.class]: Unsatisfied dependency expressed through method 'graphQlRouterFunction' parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'graphQlHttpHandler' defined in class path resource [org/springframework/boot/autoconfigure/graphql/servlet/GraphQlWebMvcAutoConfiguration.class]: Unsatisfied dependency expressed through method 'graphQlHttpHandler' parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'webGraphQlHandler' defined in class path resource [org/springframework/boot/autoconfigure/graphql/servlet/GraphQlWebMvcAutoConfiguration.class]: Unsatisfied dependency expressed through method 'webGraphQlHandler' parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'executionGraphQlService' defined in class path resource [org/springframework/boot/autoconfigure/graphql/GraphQlAutoConfiguration.class]: Unsatisfied dependency expressed through method 'executionGraphQlService' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'graphQlSource' defined in class path resource [org/springframework/boot/autoconfigure/graphql/GraphQlAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.graphql.execution.GraphQlSource]: Factory method 'graphQlSource' threw exception; nested exception is SchemaProblem{errors=[The field type 'string' is not present when resolving type 'User' [@5:1], The field type 'string' is not present when resolving type 'User' [@5:1]]}


===================================




This issue due to version of mysql. I was using 5.7 and I changed to "COMMENT 'string'" instead of VISIBLE
Caused by: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'VISIBLE,



====================================

Sample Query

query{
    users{
        id, name
    }
}