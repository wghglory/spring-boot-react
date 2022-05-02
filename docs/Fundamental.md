# Spring boot fundamental

`@SpringBootApplication` annotation is a combination of
multiple annotations, such as the following:

- `@EnableAutoConfiguration`: enables automatic configuration based on dependencies. e.g. `spring-boot-starter-web` assumes that you're developing a web application and configure it accordingly.
- `@ComponentScan`: scan to find all components 
- `@Configure`: defines a class as a source of bean definitions
