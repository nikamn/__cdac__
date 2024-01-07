
using System.Text.Json.Serialization;

namespace FirstWebAPI
{
    public class Program
    {
        public static void Main(string[] args)
        {
            WebApplicationBuilder builder = WebApplication.CreateBuilder(args);

            builder.Services.AddControllers().AddJsonOptions(
                options => options.JsonSerializerOptions.ReferenceHandler = ReferenceHandler.IgnoreCycles);

            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();

            WebApplication app = builder.Build();

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseAuthorization();

            app.MapControllerRoute(
                name: "employees",
                pattern: "{controller=Employees}/{action=Index}/{id?}");

            app.MapControllerRoute(
                name: "weatherforecasts",
                pattern: "{controller=WeatherForecast}/{action=Get}/{id?}");

            app.Run();
        }
    }
}
