@SneakyThrows
@Test void performanceTest() {
    var threadPool = Executors.newWorkStealingPool(20);

    CompletableFuture.allOf(
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool),
            CompletableFuture.supplyAsync(this::callAsync, threadPool)
    ).get();

}

private boolean callAsync() {
    int callCount = 4;
    var threadName = Thread.currentThread().getName();
    log.info("Thread {} starting up", threadName);
    for (int i = 0; i < callCount; i++) {
        if(i==(callCount/2)) log.info("Thread {} reached {} calls of total {}", threadName, i, callCount);
        callRest();
    }
    return true;
}

private void callRest() {
    restTemplate.getForObject(<URL>);
    restTemplate.getForObject(<URL>);
    restTemplate.getForObject(<URL>);
    restTemplate.getForObject(<URL>);
    restTemplate.getForObject(<URL>);
}
