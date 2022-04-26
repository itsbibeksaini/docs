![entityframework](https://user-images.githubusercontent.com/20155657/131224821-4b2a556c-54e7-48ac-a705-36e85d5b08f6.png)

Entity Framework is an open source object–relational mapping framework for ADO.NET.

Dependency required

> - Microsoft.EntityFrameworkCore.Design
> - Microsoft.EntityFrameworkCore.Tools
> - Microsoft.EntityFrameworkCore
> - Microsoft.EntityFrameworkCore.SqlServer

#### Adding support for SQL Server

> <b>Adding Middleware for SQL Server</b>

```ASP.NET
services.AddDbContext<Store>(options => options.UseSqlServer(Configuration.GetConnectionString("ConnectionString")));
```

Here in this connection string is added to <b>appsettings.json</b> and we can get the named section out of it.

#### Adding DBContext(Store) and Factory(Store Factory)

DbContext is an important class in Entity Framework API. It is a bridge between your domain or entity classes and the database. DbContext is the primary class that is responsible for interacting with the database.

Following is an expamle of Identity store:

```C#
public class IdentityStore : DbContext
    {
        public IdentityStore(DbContextOptions<IdentityStore> options) : base(options) { }

        protected override void OnModelCreating(ModelBuilder modelBuilder) { }

        public DbSet<Credential> CREDENTIALS { get; set; }
        
        public DbSet<Profile> PROFILE { get; set; }
        public DbSet<RefreshToken> REFRESH_TOKENS { get; set; }        
    }
```

Implement IDesignTimeDbContextFactory interface to enable design-time services for context types that do not have a public default constructor. At design-time, derived DbContext instances can be created in order to enable specific design-time experiences such as Migrations.

```C#
public class IdentityStoreFactory : IDesignTimeDbContextFactory<IdentityStore>
    {
        public IdentityStore CreateDbContext(string[] args)
        {
            IConfigurationRoot configuration = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json")
                .Build();

            DbContextOptionsBuilder<IdentityStore> builder = new();

            string connectionString = configuration.GetConnectionString("<Name to connection string>");

            builder.UseSqlServer(connectionString);

            return new IdentityStore(builder.Options);
        }
    }
```
