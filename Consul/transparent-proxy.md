## Transparent proxy

Transparent proxy allows users to reach other services in the service mesh while ensuring that inbound and outbound traffic for services in the mesh are directed through the sidecar proxy. 
Traffic is secured and only reaches intended destinations since the proxy can enforce security and policy like TLS and Service Intentions.

Previously, service mesh users would need to explicitly define upstreams for a service as a local listener on the sidecar proxy, and dial the local listener to reach the appropriate upstream.
Users would also have to set intentions to allow specific services to talk to one another. 

Transparent proxying reduces this duplication, by determining upstreams implicitly from Service Intentions.
Explicit upstreams are still supported in the proxy service registration on VMs and via the annotation in Kubernetes.

### Pre-requisites

* To use transparent proxy on Kubernetes, Consul-helm >= `0.32.0` and Consul-k8s >= `0.26.0` are required in addition to Consul >= `1.10.0`.
* If the default policy for ACLs is "deny", then Service Intentions should be set up to allow intended services to connect to each other. Otherwise, all Connect services can talk to all other services.

### Configuration

* Transparent proxy can be enabled for whole cluster using Helm chart

  ```yaml
  connectInject:
    transparentProxy:
      defaultEnabled: true
  ```
* It can also be enabled on a per namespace basis by setting the label `consul.hashicorp.com/transparent-proxy=true` on the Kubernetes namespace. This will override the Helm value `connectInject.transparentProxy.defaultEnabled` and define the default behavior of Pods in the namespace.
* It can also be enabled on a per service basis via the annotation `consul.hashicorp.com/transparent-proxy=true` on the Pod for each service, which will override both the Helm value and the namespace label

### Kubernetes HTTP Health Probes Configuration

Traffic redirection interferes with Kubernetes HTTP health probes since the probes expect that kubelet can directly reach the application container on the probe's endpoint, but that traffic will be redirected through the sidecar proxy, causing errors because kubelet itself is not encrypting that traffic using a mesh proxy.
For this reason, Consul allows you to overwrite Kubernetes HTTP health probes to point to the proxy instead.
This can be done using the Helm value `connectInject.transparentProxy.defaultOverwriteProbes` or the Pod annotation `consul.hashicorp.com/transparent-proxy-overwrite-probes`.
