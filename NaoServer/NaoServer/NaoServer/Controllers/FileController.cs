using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace NaoServer.Controllers
{

    public class FileController : ApiController
    {
#if DEBUG
        private string filePath = @"C:\Users\Melanie\Documents\Visual Studio 2012\Projects\NAOFileServer\NAOTestFiles";
#else
            private string filePath = @"C:\Daten\NAO";
#endif
        // GET api/values
        
        //[Route("api/files/names/{count:int}")]
        public HttpResponseMessage GetFileNamesByIndex(int count)
        {
            HttpResponseMessage message = null;

            string[] files = Directory.GetFiles(filePath);

            if (files != null)
            {
                if (files.Length - 1 >= count)
                {
                    message = this.Request.CreateResponse(HttpStatusCode.OK, files[count]);
                }
                else
                {
                    message = this.Request.CreateResponse(HttpStatusCode.BadRequest);
                }
            }

            return message;
        }

        //[Route("api/files/names")]
        public string[] GetAllFileNames()
        {
            string[] files = Directory.GetFiles(filePath);

            return files;
        }

        // GET api/values/5
       // [Route("api/files/{fileName}")]
        public HttpResponseMessage GetByFileName(string fileName)
        {
            HttpResponseMessage result = null;

            if (!String.IsNullOrEmpty(fileName))
            {
                string[] strs = fileName.Split('.');

                if (strs.Length > 0)
                {
                    string requestedFilePath = filePath + @"\" + strs[0] + ".txt";
                    if (File.Exists(requestedFilePath))
                    {
                        // sende Dateidaten an Client:
                        byte[] bytes = File.ReadAllBytes(requestedFilePath);


                        result = Request.CreateResponse(HttpStatusCode.OK);
                        result.Content = new ByteArrayContent(bytes);
                        result.Content.Headers.Add("X-DownloadedFile", requestedFilePath);
                    }
                    else
                    {
                        string errMsg = "File not found.";
                        result = new HttpResponseMessage(HttpStatusCode.NotFound)
                        {
                            Content = new StringContent(errMsg),
                            ReasonPhrase = errMsg,
                        };
                        throw new HttpResponseException(result);
                    }
                }
                else
                {
                    string errMsg = "Unsopported name of file.";
                    result = new HttpResponseMessage(HttpStatusCode.BadRequest)
                    {
                        Content = new StringContent(errMsg),
                        ReasonPhrase = errMsg,
                    };
                    throw new HttpResponseException(result);
                }
            }
            else
            {
                string errMsg = "Filename must not be null.";
                result = new HttpResponseMessage(HttpStatusCode.BadRequest)
                {
                    Content = new StringContent(errMsg),
                    ReasonPhrase = errMsg,
                };
                throw new HttpResponseException(result);
            }

            return result;

        }
    }
}
