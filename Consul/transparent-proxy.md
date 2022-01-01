## Transparent proxy

Transparent proxy allows users to reach other services in the service mesh while ensuring that inbound and outbound traffic for services in the mesh are directed through the sidecar proxy. 
Traffic is secured and only reaches intended destinations since the proxy can enforce security and policy like TLS and Service Intentions.

Previously, service mesh users would need to explicitly define upstreams for a service as a local listener on the sidecar proxy, and dial the local listener to reach the appropriate upstream.
Users would also have to set intentions to allow specific services to talk to one another. 

Transparent proxying reduces this duplication, by determining upstreams implicitly from Service Intentions.
Explicit upstreams are still supported in the proxy service registration on VMs and via the annotation in Kubernetes.