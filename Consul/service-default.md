## Service default

The service-defaults config entry kind (ServiceDefaults on Kubernetes) controls default global values for a service, such as its protocol.

> The default protocol can also be configured globally for all proxies using the proxy defaults config entry. However, if the protocol value is specified in a service defaults config entry for a given service, that value will take precedence over the globally configured value from proxy defaults.

```yaml
apiVersion: consul.hashicorp.com/v1alpha1
kind: ServiceDefaults
metadata:
  name: web
spec:
  protocol: http
```
