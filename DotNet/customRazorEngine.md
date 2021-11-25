## Custom razor engine

### View engine
> The View Engine is responsible for producing an HTML response when invoked by the Controller Action method.The Controller Action methods can return various types of responses, which are collectively called as Action Results. The ViewResult is the ActionResult which produces the HTML Response. The ViewResults are produced by the View Engine. When the Controller Action method invokes the view() or PartivalView(), it invokes the View Engine, which produces the HTML Response.

### Razor view engine
> The Razor View Engine is the default View Engine for the ASP.NET Core apps. It looks for Razor markup in the View File and parses it and produces the HTML response.

```C#
public async Task<string> RazorViewToHtmlAsync<TModel>(string viewName, TModel model)
{
    var actionContext = GetContext();
    var view = FindView(viewName);

    using var output = new StringWriter();

    var viewContext = new ViewContext(
    actionContext: actionContext,
    view: view,
    viewData: new ViewDataDictionary<TModel>(
        metadataProvider: new EmptyModelMetadataProvider(),
        modelState: new ModelStateDictionary()
        )
    {
        Model = model
    },
    tempData: new TempDataDictionary(actionContext.HttpContext, _tempDataProvider),
    writer: output,
    htmlHelperOptions: new HtmlHelperOptions()
    );
    await view.RenderAsync(viewContext);
    return output.ToString();

}
```
