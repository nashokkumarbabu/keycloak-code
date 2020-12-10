var session = require('express-session');
var Keycloak = require('keycloak-connect');

let _keycloak;

var keycloakConfig = {
    clientId: 'webapp',
    bearerOnly: true,
    serverUrl: 'http://localhost:8080/auth',
    realm: 'VSource',
    credentials: {
        secret: '32b86cab-c24e-43e5-9853-9242bbf2cfe0'
    }
};

function initKeycloak() {
    if (_keycloak) {
        console.warn("Trying to init Keycloak again!");
        return _keycloak;
    } 
    else {
        console.log("Initializing Keycloak...");
        var memoryStore = new session.MemoryStore();
        _keycloak = new Keycloak({ store: memoryStore }, keycloakConfig);
        console.log(_keycloak);
        return _keycloak;
    }
}

function getKeycloak() {
    if (!_keycloak){
        console.error('Keycloak has not been initialized. Please called init first.');
    } 
    return _keycloak;
}

module.exports = {
    initKeycloak,
    getKeycloak
};