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