## Custom razor engine

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