var server = require("./routing1");
var router = require("./router1")
server.start(router.route);
