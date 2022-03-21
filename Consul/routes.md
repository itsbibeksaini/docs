## Routes 
Routes tell your Consul API Controller how to handle traffic into your service mesh.

```yaml
apiVersion: gateway.networking.k8s.io/v1alpha2
kind: HTTPRoute
metadata:
  name: example-route-1
spec:
  parentRefs:
  - name: example-gateway
  rules:
  - matches:
    - path:
        type: PathPrefix
        value: /
    backendRefs:
    - kind: Service
      name: echo-1
      port: 8080
      weight: 1000    
```
