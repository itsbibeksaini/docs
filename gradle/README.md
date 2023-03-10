# Gradle

Creating gradle cache in azure pipeline

```yml
- task: Cache@2
  displayName: Gradle cache
  condition: ne(variables.GRADLE_HOME, '')
  inputs:
    key: 'gradleV1 | "$(Agent.OS)" | **/build.gradle.kts, **/build.gradle'
    restoreKeys: |
      gradleV1 | "$(Agent.OS)"
      gradleV1
    path: $(GRADLE_HOME)
```

Add the valiable in template to set `GRADLE_HOME`
```yml
- name: "GRADLE_HOME"
  value: $(Pipeline.Workspace)/.gradle
```


This will be followed by adding `--build-cache` attribute to configured gradle tasks

```yml
tasks: <tasks> --build-cache
```

After this complete we need to stop gradle daemon as well:
```yml
- script: |       
    ./gradlew --stop    
  displayName: Gradlew stop
```
