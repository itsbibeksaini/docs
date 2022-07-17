## Consul API Gateway

Control Access into the Service Mesh with Consul API Gateway


### Create the Consul API Gateway Controller CRDs
Create the custom resource definitions (CRD) for the API Gateway Controller.
```
kubectl apply --kustomize "github.com/hashicorp/consul-api-gateway/config/crd?ref=v0.3.0"
```
### Consul helm config

```yaml
## It will configure consul api gateway.
apiGateway:
 enabled: true
 image: "hashicorp/consul-api-gateway:0.3.0"
 logLevel: debug
```

### API Gateway configuration
The API Gateway Controller consists of multiple components that facilitate ingress into your Consul service mesh.

```yaml
apiVersion: gateway.networking.k8s.io/v1alpha2
kind: Gateway
metadata:
  name: example-gateway
spec:
  gatewayClassName: consul-api-gateway
  listeners:
  - protocol: HTTPS
    port: 443
    name: https
    allowedRoutes:
      namespaces:
        from: Same
    tls:
      certificateRefs:
        - name: consul-server-cert
```
