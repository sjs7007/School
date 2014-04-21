var http = require("http");

http.createServer(
	function(request,response)
	{
		response.writeHead(400,{"Content-Type":"text/plain"});
		response.write("Hello World!");
		response.end();
	}
	).listen(8888);
	
