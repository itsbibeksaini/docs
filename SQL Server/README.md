## SQL Server

Microsoft SQL Server is a relational database management system developed by Microsoft. As a database server, it is a software product with the primary function of storing and retrieving data as requested by other software applications—which may run either on the same computer or on another computer across a network.

### Running SQL Server in Docker container
One can grab latest docuer container image for SQL seerver from hub.docker: https://hub.docker.com/_/microsoft-mssql-server
> This is official image for Microsoft SQL Server on Linux for Docker Engine.

#### Pulling image
Use the Docker command below to fetch and extract latest Docker Image for MS SQL Server.
> docker pull mcr.microsoft.com/mssql/server:2019-latest

After image is pulled and extracted now its time to create Docker container for the image we just pulled.
> sudo docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=```<Your strong password>``` -p 1433:1433 --restart always --name="mssql-server-2019"  -d mcr.microsoft.com/mssql/server:2019-latest

The command above require sudo(superuser do) to perform thee opperation at root.
Make sure to keep a strong password even you are running this on local system.

To use MS Sql server in application you can add server address as: ```host.docker.internal,1433```
> Docker internal which resolves to the internal IP address used by the host. This is for development purpose and will not work in a production environment
