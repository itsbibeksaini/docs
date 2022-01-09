## Prroxy default

The proxy-defaults config entry kind (ProxyDefaults on Kubernetes) allows for configuring global config defaults across all services for Connect proxy configuration. Currently, only one global entry is supported.

### Sample config entrie

```yaml
apiVersion: consul.hashicorp.com/v1alpha1
kind: ProxyDefaults
metadata:
  name: global
spec:
  config:
    protocol: http
```
