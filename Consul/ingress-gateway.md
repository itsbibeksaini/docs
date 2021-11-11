## Ingress gateway

Ingress gateways enable ingress traffic from services outside the Consul service mesh to services inside the Consul service mesh. An ingress gateway is a type of proxy and must be registered as a service in Consul, with the kind set to "ingress-gateway". They are an entrypoint for outside traffic and allow you to define what services should be exposed and on what port.

### Setting up helm chart config

```yaml
global:
  name: consul
connectInject:
  enabled: true
controller:
  enabled: true
ingressGateways:
  enabled: true
  gateways:
    - name: ingress-gateway
      service:
        type: LoadBalancer
```

> This will create a public unauthenticated LoadBalancer in your cluster, please take appropriate security considerations.

### Configuring the gateway

Now that Consul has been installed with ingress gateways enabled, you can configure the gateways via the IngressGateway custom resource.

```yaml
apiVersion: consul.hashicorp.com/v1alpha1
kind: IngressGateway
metadata:
  name: ingress-gateway
spec:
  listeners:
    - port: 8080
      protocol: http
      services:
        - name: static-server
```

Since we're using protocol: http, we also need to set the protocol of our service static-server to http. To do that, we create a ServiceDefaults custom resource:

```yaml
apiVersion: consul.hashicorp.com/v1alpha1
kind: ServiceDefaults
metadata:
  name: static-server
spec:
  protocol: http
```