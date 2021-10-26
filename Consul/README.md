## Consul

Consul is a service networking solution to automate network configurations, discover services, and enable secure connectivity across any cloud or runtime.

## Config

> Following are the configuration which is being used to make use of consul service discovery.

```yaml
## Holds values that affect multiple components of the chart.
global:
  ## Set the prefix used for all resources in the Helm chart. If not set, the prefix will be <helm release name>-consul.
  name: consul
  ## The name of the datacenter that the agents should register as.
  datacenter: TMSolution
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

## Configures a demo Prometheus installation.
 prometheus:
  ## When true, the Helm chart will install a demo Prometheus server instance alongside Consul.
  enabled: true

## Values that configure the Consul UI.
ui:
  ##  If true, the UI will be enabled.
  enabled: true
  ## Configure the service for the Consul UI.
  service:
    ## The service type to register.
    type: 'ClusterIP'
  ## Configurations for displaying metrics in the UI.
  metrics:
    ## Enable displaying metrics in the UI.
    enabled: true
    ## Provider for metrics.
    provider: "prometheus"
    ## baseURL is the URL of the prometheus server, usually the service URL.
    baseURL: http://prometheus-server

## Configures the automatic Connect sidecar injector.
connectInject:
  ## True if you want to enable connect injection.
  enabled: true
  ## Configures Transparent Proxy for Consul Service mesh services.
  transparentProxy:
    ## If true, then all Consul Service mesh will run with transparent proxy enabled by default, i.e. we enforce that all traffic within the pod will go through the proxy.
    defaultEnabled: true

## Controller handles config entry custom resources.
controller:
  ## Enables the controller for managing custom resources.
  enabled: true

## Values that configure running a Consul client on Kubernetes nodes.
client:
  ## If true, the chart will install all the resources necessary for a Consul client on every Kubernetes node.
  enabled: true
  ## If true, agents will enable their GRPC listener.
  grpc: true

# Use only one Consul server for local development
## Server, when enabled, configures a server cluster to run.
server:
  ## The number of server agents to run.
  replicas: 1
  ## The number of servers that are expected to be running.
  bootstrapExpect: 1
  ## This configures the PodDisruptionBudget.
  disruptionBudget:
    ## This will enable/disable registering a PodDisruptionBudget for the server cluster.
    enabled: true
    ## The maximum number of unavailable pods.
    maxUnavailable: 0
```

| Topics                     |
| :------------------------- |
| [Ingress gateway]() |
| [Transparent proxy]()      |
| [Service default]()       |
| [Service router]()        |
| [Proxy default]()         |
