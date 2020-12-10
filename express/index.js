var express = require('express');
var app = express();
const keycloak = require('./config/keycloak-config.js').initKeycloak();
var testController = require('./controller/test-controller.js');

app.use(keycloak.middleware());
app.get('/', function(req, res){
   res.send("Server is up!");
});


app.use('/test', testController);

app.listen(3000);