## Startup task

These tasks should be executed before the app starts accepting requests, but may require configuration and services, so should be executed after DI configuration is complete.

Examples include things like database migrations, or populating a cache.

### Registering startup tasks with the DI container

This is based on the patterns used by IStartupFilter and IHostedService.

First, we create a simple interface for the startup tasks

```ASP.NET
public interface IStartupTask
{
    Task ExecuteAsync(CancellationToken cancellationToken = default);
}
```

And a convenience method for registering startup tasks with the DI container:

```ASP.NET
public static class ServiceCollectionExtensions
{
    public static IServiceCollection AddStartupTask<T>(this IServiceCollection services)
        where T : class, IStartupTask
        => services.AddTransient<IStartupTask, T>();
}
```

Finally, we add an extension method that finds all the registered IStartupTasks on app startup, runs them in order, and then starts the IWebHost:

```ASP.NET
public static class StartupTaskWebHostExtensions
{
    public static async Task RunWithTasksAsync(this IWebHost webHost, CancellationToken cancellationToken = default)
    {
        // Load all tasks from DI
        var startupTasks = webHost.Services.GetServices<IStartupTask>();

        // Execute all the tasks
        foreach (var startupTask in startupTasks)
        {
            await startupTask.ExecuteAsync(cancellationToken);
        }

        // Start the tasks as normal
        await webHost.RunAsync(cancellationToken);
    }
}
```

That's all there is to it!

Startup tasks we have:

| Topic           |
| :-------------- |
| [Warmup services]() |
| [DB Migrations]() |
