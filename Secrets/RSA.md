# RSA - Public and Private Keys

## Generate private key
```
openssl genrsa -out private-key.pem 4096
```

## Generate corresponding public key
```
openssl rsa -in private-key.pem -pubout -out public-key.pem
```

## Creating k8s secret for PUBLIC_KEY and PRIVATE_KEY
```
kubectl create secret generic tmsolution-jwt-secrets --from-file=PRIVATE_KEY=private-key.pem --from-file=PUBLIC_KEY=public-key.pem --from-literal=ISSUER=<ISSUER> --from-literal=AUDIENCE=<AUDIENCE> --from-literal=TTL=5
```
> This also consist of JWT properies.
