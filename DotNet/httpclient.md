## HTTP Client

Provides a class for sending HTTP requests and receiving HTTP responses from a resource identified by a URI.

Dependency required
> - Microsoft.Extensions.DependencyInjection
> - Newtonsoft.Json
> - Microsoft.Extensions.Http

```C#
public class TMClient
    {
        private readonly HttpClient _httpClient;
        private readonly string _baseUrl = "http://localhost:8080/";
        private static JsonSerializerSettings MicrosoftDateFormatSettings
        {
            get
            {
                return new JsonSerializerSettings
                {
                    DateFormatHandling = DateFormatHandling.MicrosoftDateFormat
                };
            }
        }

        public TMClient(IHttpContextAccessor httpContext)
        {
            var token = httpContext.HttpContext.Request.Headers[HeaderNames.Authorization];
            HttpClientHandler clientHandler = new ()
            {
                ServerCertificateCustomValidationCallback = (sender, cert, chain, sslPolicyErrors) => { return true; }
            };

            // Pass the handler to httpclient(from you are calling api)
            _httpClient = new HttpClient(clientHandler);

            if(!string.IsNullOrEmpty(token))
                _httpClient.DefaultRequestHeaders.Authorization = new System.Net.Http.Headers.AuthenticationHeaderValue("Bearer", token[0]["Bearer ".Length..]);

            _httpClient.DefaultRequestHeaders.Add("Host", "accountapi.ingress.tmsolution.consul");
            
        }

        public void Dispose()
        {
            _httpClient.Dispose();
        }

        public void SetAuthorizationBearer(string token)
        {
            _httpClient.DefaultRequestHeaders.Authorization = new System.Net.Http.Headers.AuthenticationHeaderValue("Bearer", token);
        }

        /// <summary>
        /// Add query parameters provided in dictionary to GET request.
        /// </summary>
        /// <param name="data"></param>
        public string AddQueryParams(Dictionary<string, string> data)
        {
            string queryParams = "";

            if (data.Count > 0)
            {
                queryParams += "?";
                int paramCounter = 0;
                foreach (var param in data)
                {
                    queryParams += param.Key + "=" + param.Value;
                    paramCounter++;

                    // denotes there are more query parameters in dictionary, add & character to separate them.
                    if (paramCounter < data.Count)
                    {
                        queryParams += "&";
                    }
                }
            }

            return queryParams;
        }

        /// <summary>
        /// GET api request to given controller and action.
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="action"></param>
        /// <param name="controller"></param>
        /// <returns></returns>
        /// 
        public async Task<HttpResponseMessage> GetAsync(string action, string controller, Dictionary<string, string> data = null)
        {
            string queryParams = "";
            if (data != null)
                queryParams = AddQueryParams(data);

            Uri serviceUri = new(string.Concat(_baseUrl, controller, "/", action, queryParams));

            HttpResponseMessage response = await _httpClient.GetAsync(serviceUri);

            return response;
        }

        public async Task<HttpResponseMessage> PostAsync(string action, string controller, Object data)
        {
            Uri serviceUri = new(string.Concat(_baseUrl, controller, "/", action));
            HttpResponseMessage response = null;
            
            try
            {
                response = await _httpClient.PostAsync(serviceUri.AbsoluteUri, CreateHttpContent(data));
            }
            catch(HttpRequestException e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine(e.InnerException);
                Console.WriteLine(e.StackTrace);
            }


            return response;
        }

        private HttpContent CreateHttpContent(Object content)
        {
            var json = JsonConvert.SerializeObject(content, MicrosoftDateFormatSettings);
            return new StringContent(json, Encoding.UTF8, "application/json");
        }
    }
```
