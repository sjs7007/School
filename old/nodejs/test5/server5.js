var http = require("http");
var url = require("url");
var express = require('express');
var app = express();

function start(route,handle)
{
	function onRequest(request,response)
	{
		var pathname = url.parse(request.url).pathname;
		console.log("Request for "+ pathname + " received.");

		route(handle,pathname,response);

		/*response.writeHead(200,{"Content-Type" : "text/plain"});
		
		var content=route(handle,pathname);

		response.write(content);
		response.end();*/
	}

	//http.createServer(onRequest).listen(8888);
	var port = process.env.PORT || 8888;
	http.createServer(onRequest).listen(port);	
	console.log("Server has started.");
}

exports.start=start;
