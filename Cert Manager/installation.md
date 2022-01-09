## Installation

### Default static install

```
kubectl apply -f https://github.com/jetstack/cert-manager/releases/download/v1.6.1/cert-manager.yaml
```

### Installing with Helm

cert-manager provides Helm charts as a first-class method of installation on both Kubernetes and OpenShift.

> Be sure never to embed cert-manager as a sub-chart of other Helm charts; cert-manager manages non-namespaced resources in your cluster and care must be taken to ensure that it is installed exactly once.

#### Steps

1. Add the Jetstack Helm repository:

```
helm repo add jetstack https://charts.jetstack.io
```

2. Update your local Helm chart repository cache:

```
helm repo update
```

3. Install CustomResourceDefinitions

   - Installing CRDs with kubectl
     ```
     kubectl apply -f https://github.com/jetstack/cert-manager/releases/download/v1.6.1/cert-manager.crds.yaml
     ```
   - Install CRDs as part of the Helm release
     > To automatically install and manage the CRDs as part of your Helm release, you must add the --set installCRDs=true flag to your Helm installation command.

4. Install cert-manager
   To install the cert-manager Helm chart, use the Helm install command as described below.

   ```
   helm install \
   cert-manager jetstack/cert-manager \
   --namespace cert-manager \
   --create-namespace \
   --version v1.6.1 \
   --set installCRDs=true
   ```

### Uninstalling

> Warning: To uninstall cert-manger you should always use the same process for installing but in reverse. Deviating from the following process whether cert-manager has been installed from static manifests or Helm can cause issues and potentially broken states. Please ensure you follow the below steps when uninstalling to prevent this happening.

Before continuing, ensure that all cert-manager resources that have been created by users have been deleted. You can check for any existing resources with the following command:

```
kubectl get Issuers,ClusterIssuers,Certificates,CertificateRequests,Orders,Challenges --all-namespaces
```

#### Uninstalling with Helm
Uninstalling cert-manager from a helm installation is a case of running the installation process, in reverse, using the delete command on both kubectl and helm.

```
helm --namespace cert-manager delete cert-manager
```

Next, delete the cert-manager namespace:

```
kubectl delete namespace cert-manager
```

Finally, delete the cert-manger CustomResourceDefinitions using the link to the version vX.Y.Z you installed:

```
kubectl delete -f https://github.com/jetstack/cert-manager/releases/download/vX.Y.Z/cert-manager.crds.yaml
```
