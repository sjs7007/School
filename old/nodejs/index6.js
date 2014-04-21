var server = require("./server6");
var router = require("./router6");
var requestHandlers = require("./requestHandlers6");

var handle = {};
handle["/"] = requestHandlers.start;
handle["/start"] = requestHandlers.start;
handle["/upload"] = requestHandlers.upload;

server.start(router.route,handle);
