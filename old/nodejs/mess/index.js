var router=require("./router");
var server=require("./server");
var requestHandlers=require("./requestHandlers");

var handle={};
handle["/"]=requestHandlers.start;
handle["/start"]=requestHandlers.start;
handle["/upload"]=requestHandlers.upload;
handle["/java"]=requestHandlers.java;
handle["/c"]=requestHandlers.c;

server.start(router.route,handle);
