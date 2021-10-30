## Authorization

Authorization is the function of specifying access rights/privileges to resources, which is related to general information security and computer security, and to access control in particular.

Dependency required

> - Microsoft.AspNetCore.Authentication.JwtBearer

#### Adding authorization support

To enable authorization in your .NET Core application add the following to ConfigureService section of your startup.

> <b>Here we are using Jwt bearer for authorization based on JWT tokne.</b>

```C#
services.AddAuthentication(options =>
            {
                options.DefaultAuthenticateScheme = JwtBearerDefaults.AuthenticationScheme;
                options.DefaultChallengeScheme = JwtBearerDefaults.AuthenticationScheme;
            })
```

> <b>Here you can provide your symetric key and other issuer parameters to validate JWT tokne.</b>

```C#
services.AddJwtBearer(options =>
            {
                options.RequireHttpsMetadata = false;
                options.SaveToken = true;
                options.TokenValidationParameters = new TokenValidationParameters
                {
                    ValidateIssuerSigningKey = true,
                    IssuerSigningKey = new SymmetricSecurityKey(key),
                    ValidateIssuer = false,
                    ValidateAudience = false
                };
            });
```

> <b>And add use authorization in Configure to enable its usage.</b>

```C#
app.UseAuthorization();
```
