# Renovate

Configure scan to private artifacts
```yml
version: 2
registries:
  maven-artifactory:
    type: maven-repository
    url: <URL-TO-ARTIFACTS>
    username: <USERNAME>
    password: <SECRET>
    replaces-base: true
updates:
  - package-ecosystem: "gradle"
    directory: "/"
    registries:
      - maven-artifactory
    schedule:
      interval: "weekly"
```

| Property | Value |
| :-- | :-- |
| url | url to artifact registory |
| username | username to artifact registory |
| password | passowrd to artifact reigstory(always add it to secrets) |
