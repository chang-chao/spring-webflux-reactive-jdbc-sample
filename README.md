# spring-webflux-reactive-jdbc-sample
This is an example program for demonstrating How do we integrate the inherently blocking JDBC API to the world of reactive programming.

The point is to have a dedicated, well-tuned thread pool and isolate the blocking code there.

# functionality
A simple `city` table which consists of `id`(auto-generated pk), `country` and `name` columns is used.

## Blocking version
| URL                           | functionality                                               |
| ----------------------------- |:------------------------------------------------------------|
| http://localhost:8080/        | list all cities                                             |
| http://localhost:8080/one     | get one city(for simplicity, a fixed city is queried)       |
| http://localhost:8080/add     | add a city with a random name                               |

## Non-blocking version.
| URL                              | functionality                                               |
| -------------------------------- |:------------------------------------------------------------|
| http://localhost:8080/rx/        | list all cities                                             |
| http://localhost:8080/rx/one     | get one city(for simplicity, a fixed city is queried)       |
| http://localhost:8080/rx/add     | add a city with a random name                               |

# Reference:
1. https://www.changchao.me/?p=795
1. http://musigma.org/java/2016/11/21/reactor.html
1. https://stackoverflow.com/questions/42299455/spring-webflux-and-reading-from-database
1. https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-data-jpa
1. http://www.grahamlea.com/2014/07/rxjava-threading-examples/
1. https://spring.io/blog/2016/07/20/notes-on-reactive-programming-part-iii-a-simple-http-server-application
