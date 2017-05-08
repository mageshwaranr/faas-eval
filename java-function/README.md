# Java Function
Java based function to simulate business function. I/O is shared via Std IN/OUT

Accepts inputs via std.in in JSON format. Following are the attributes
 * respondIn : attribute defines the response should be sent after this interval
 * responseStr : response string that will be sent to System.out as a JSON  named data
 * exitCode : the code with which program exits

Returns out as JSON containing following attributes
* data : responseStr passed in
* prop : a map containing java system props
* prop : a map containing system env variables 

## Usage

Run docker:distDocker gradle tasks. Create a docker image which can be used in iron-functions.

Latest docker images is available as mageshwaranr/faas-eval-java-fn