[![Build Status](https://travis-ci.com/ocornejo/programmingtest.svg?branch=master)](https://travis-ci.com/ocornejo/programmingtest.svg?branch=master)
<br />

# Programming Test - Pattern Recognition

This project implements a REST API that allows the caller from a given a set of points in the bidimensional plane, determine every line that contains at least N or more collinear points.

This solution is based on Jersey (RESTful Web Services in Java - https://jersey.github.io/).
The implementation contains two main packages, the resource and the service packages: the resource package handles the HTTP requests and the service package provide the required actions/information.

## Assumptions

When invoking the following request:

```
GET /lines/{n}
```

It will always return *the longest line segment* passing through at least N points. It will return more than one line segment, only if they have the same length.

## Prerequisites:
* Tomcat 9
* JDK 1.8
* Maven 3.*

## Install and run the project 
1. download/clone the project 
2. from the main folder run:
	* `mvn clean install`
3. deploy `target/programmingtest-0.0.1.war` to your Tomcat installation
4. start Tomcat
4. the REST API now it is available from http://localhost:8080/programmingtest-0.0.1/
