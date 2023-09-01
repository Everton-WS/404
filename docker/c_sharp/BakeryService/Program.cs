using MySqlConnector;

var builder = WebApplication.CreateBuilder(args);

builder.services.AddTransient<MySqlConnection>(_ =>
    new MySqlConnection(builder.Configuration.GetConnectionString["Default"]));


using var connection = new MySqlConnection(IConfiguration.GetConnectionString('default'));

await connection.OpenAsync();

using var command = new MySqlCommand("SELECT * FROM Padarias;", connection);
using var reader = await command.ExecuteReaderAsync();
while (await reader.ReadAsync())
{
    var value = reader.GetValue(0);
    // do something with 'value'
}

var app = builder.Build();

app.MapGet("/", () => "Hello World!");

app.Run();
