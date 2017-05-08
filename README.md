# serverless / Functions As A Service

A sample project to explore serverless aka FAAS architecture in a cloud agnostic manner

##Lambdas aka Functions

Lambdas is considered as a process capable of running business logic in response to an event. Key characteristics are

* Finite
    * not always running rather starts on demand and completes with in a span of time (minutes).
* Stateless & share nothing across executions
    * can not maintain any state in current process. Function should depend on external process for all state requirements

## Non Functional Requirements
* Need a Cloud agnostic Lambda execution service. Though this is similar to AWS Lambda / Cloud functions, they can't interchangeable in terms of constraints and capability offerings.
* Should run on top of Kubernetes.
* We should be able to control the no. of concurrent executions of a particular type of function
    * Why ? Kubernetes cluster needs to be scaled enough and no lambda can over consume resources
* Ops aspects
    * Monitoring (track lambda executions and results of those)
    * Logging (Log should be preserved after executions)
    * Developer friendly (Runnable in local env)
    
### Out Of Scope
* Building and package the function.
    * For this exploration, I'm considering any docker container as a function. Programming language agnostic and at the same time removes the overhead of build and packaging
* Infinite Scale

## Options
We can add more options here. 
* iron.io
