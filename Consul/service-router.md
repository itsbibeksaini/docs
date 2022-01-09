## Service router

The service-router config entry kind (ServiceRouter on Kubernetes) controls Connect traffic routing and manipulation at networking layer 7 (e.g. HTTP).

### Sample config entries

```yaml
apiVersion: consul.hashicorp.com/v1alpha1
kind: ServiceRouter
metadata:
  name: web
spec:
  routes:
    - match:
        http:
          pathPrefix: /admin
      destination:
        service: admin
  # NOTE: a default catch-all will send unmatched traffic to "web"
```

### Header/query parameter matching

```yaml
apiVersion: consul.hashicorp.com/v1alpha1
kind: ServiceRouter
metadata:
  name: web
spec:
  routes:
    - match:
        http:
          header:
            - name: x-debug
              exact: '1'
      destination:
        service: web
        serviceSubset: canary
    - match:
        http:
          queryParam:
            - name: x-debug
              exact: '1'
      destination:
        service: web
        serviceSubset: canary
  # NOTE: a default catch-all will send unmatched traffic to "web"
```

### gRPC routing

```yaml
apiVersion: consul.hashicorp.com/v1alpha1
kind: ServiceRouter
metadata:
  name: billing
spec:
  routes:
    - match:
        http:
          pathExact: /mycompany.BillingService/GenerateInvoice
      destination:
        service: invoice-generator
  # NOTE: a default catch-all will send unmatched traffic to "billing"
```