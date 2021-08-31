## Consul

Consul is a service networking solution to automate network configurations, discover services, and enable secure connectivity across any cloud or runtime.

##Config

```yaml
## Holds values that affect multiple components of the chart.
global:
  ## Set the prefix used for all resources in the Helm chart. If not set, the prefix will be <helm release name>-consul.
  name: consul
  ## The name of the datacenter that the agents should register as.
  datacenter: datacenter1
  ## Configures which Kubernetes secret to retrieve Consul's gossip encryption key from
  gossipEncryption:
    ## secretName is the name of the Kubernetes secret that holds the gossip encryption key.
    secretName: "consul-gossip-encryption-key"
    ## secretKey is the key within the Kubernetes secret that holds the gossip encryption key
    secretKey: "key"
  ## Enables TLS across the cluster to verify authenticity of the Consul servers and clients.
  tls:
    ## If true, the Helm chart will enable TLS for Consul servers and clients and all consul-k8s-control-plane components, as well as generate certificate authority (optional) and server and client certificates.
    enabled: true
    ##  If true, turns on the auto-encrypt feature on clients and servers.
    enableAutoEncrypt: true
    ## If true, verify_outgoing, verify_server_hostname, and verify_incoming_rpc will be set to true for Consul servers and clients
    verify: true
  ## Configure ACLs.
  acls:
    ## If true, the Helm chart will automatically manage ACL tokens and policies for all Consul and consul-k8s-control-plane components.
    manageSystemACLs: true
  ## Configures metrics for Consul service mesh
  metrics:
    ## Configures the Helm chart’s components to expose Prometheus metrics for the Consul service mesh.
    enabled: true
    ## If true, mesh, terminating, and ingress gateways will expose their Envoy metrics on port 20200 at the /metrics path and all gateway pods will have Prometheus scrape annotations.
    enableGatewayMetrics: true
```
