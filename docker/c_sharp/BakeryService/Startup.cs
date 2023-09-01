using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;

public void ConfigureServices(IServiceCollection services)
{
    // ...

    var connectionString = Configuration.GetConnectionString("Default");
    services.AddDbContext<ApplicationDbContext>(options =>
        options.UseMySql(connectionString));
    
    // ...
}

