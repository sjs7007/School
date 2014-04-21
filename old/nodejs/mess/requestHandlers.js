var exec = require("child_process").exec;

function start(response)
{
	console.log("Request handler 'start' was called.");
	exec("ls -lah",function(error,stdout,stderr)
			{
				response.writeHead(200,{"Content-Type" : "text/plain"});
				response.write(stdout);
				response.write(stderr);
				response.end();
			}	

	);
}

function upload(response)
{
	console.log("Request handler 'upload' was called.");
	response.writeHead(200,{"Content-Type":"text/plain"});
	response.write("Hello upload.");
	response.end();
}

function java(response)
{
	console.log("Request handler 'java' was called.");
	exec("javac test.java;java test",
	function (error,stdout,stderr)
	{
		response.writeHead(200,{"Content-Type":"text/plain"});
		response.write(stdout);
		response.write(stderr);
		response.end();
	});

}

exports.start = start;
exports.upload = upload;
exports.java = java;
