# Iron Functions

Evaluate Iron functions as a means to achieve FAAS in private cloud specifically on top of kubernetes.

This is more cater to a specific use case I have and do not consider this as a evaluation of iron functions.

##Java Function
Uses mageshwaranr/faas-eval-java-fn image for evaluation.

Capabilities of the image at https://hub.docker.com/r/mageshwaranr/faas-eval-java-fn/  

### Quick Start
Prerequisite: Need a working Kubernetes, and a locally configured kubectl.

Steps

* Clone iron io functions. We need to create few k8s resources 
    * git clone https://github.com/iron-io/functions
    * cd functions/docs/kubernetes/kubernetes-quick

* Create a new namespace in which we will do the quick start. (optional but helps in cleanup. Simply delete namespace)
    * kubectl create namespace lambda // creates lambda namespace
    * alias kubectlf='kubectl --namespace=lambda'  // creates an alias instead of providing namespace everytime

* Configure IRON functions (quick start mode. No persistence in this mode)
    * kubectlf create -f . --namespace=lambda // this runs functions service
    * kubectlf describe svc functions // verify whether functions service is created and AWS ELB is created
    * export IRON_FUNCTION=$(kubectlf get -o json svc functions | jq -r '.status.loadBalancer.ingress[0].hostname'):8080  // populates a var with iron url
    
* Register an APP 
    * curl -H "Content-Type: application/json" -X POST -d '{ "app": { "name":"my-java-app" } }' http://$IRON_FUNCTION/v1/apps
    
* Register a Route. An app can have multiple routes. Each route along with app should uniquely identify a function
    * curl -H "Content-Type: application/json" -X POST -d '{ "route": { "type": "sync", "path":"/eval", "image":"mageshwaranr/faas-eval-java-fn" } }' http://$IRON_FUNCTION/v1/apps/my-java-app/routes
    
* Trigger the function with some input
    *  curl -H "Content-Type: application/json" -X POST -d '{ "respondIn" : 1000, "responseStr" : "test" , "exitCode" : 0 }' http://$IRON_FUNCTION/r/my-java-app/eval

After a seconds delay, you should see a json out with following attributes. data, env, props.