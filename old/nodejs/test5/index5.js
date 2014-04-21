var server = require("./server5");
var router = require("./router5");
var requestHandlers = require("./requestHandlers5");

var handle = {};
handle["/"] = requestHandlers.start;
handle["/start"] = requestHandlers.start;
handle["/upload"] = requestHandlers.upload;

server.start(router.route,handle);
