![swaggerui](https://user-images.githubusercontent.com/20155657/131224783-1718e3f8-446f-4b29-b352-6eab22812303.png)

## Swagger UI

Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON. Swagger is used together with a set of open-source software tools to design, build, document, and use RESTful web services.

Dependencies required:

> - Swashbuckle.AspNetCore.SwaggerGen
> - Swashbuckle.AspNetCore.SwaggerUI

> <b>Add the following code to ConfigureServices of startup of your app</b>

```ASP.NET
services.AddSwaggerGen(swagger =>
            {
                swagger.SwaggerDoc("v1", new OpenApiInfo { Title = "Title of service", Version = "v1" });
                swagger.AddSecurityDefinition("Bearer", new OpenApiSecurityScheme
                {
                    In = ParameterLocation.Header,
                    Description = "Please insert JWT with Bearer into info field",
                    Name = "Authorization",
                    Type = SecuritySchemeType.ApiKey
                });
                swagger.AddSecurityRequirement(new OpenApiSecurityRequirement
                {
                    {
                        new OpenApiSecurityScheme
                        {
                            Reference = new OpenApiReference
                            {
                                Type = ReferenceType.SecurityScheme,
                                Id = "Bearer"
                            }
                        },
                        Array.Empty<string>()
                    }
                });

                // Set the comments path for the Swagger JSON and UI.
                var xmlFile = $"{Assembly.GetExecutingAssembly().GetName().Name}.xml";
                var xmlPath = Path.Combine(AppContext.BaseDirectory, xmlFile);
                swagger.IncludeXmlComments(xmlPath);
            });
```

> <b>Add following in Configure of your app startup.</b>

```ASP.NET
app.UseSwaggerUI(c =>
                {
                    c.SwaggerEndpoint("/swagger/v1/swagger.json", "Name of service");
                    c.DocumentTitle = "Name of service";
                    c.DefaultModelsExpandDepth(-1);

                });
```
