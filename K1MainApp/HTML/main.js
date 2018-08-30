
// from java bridge
/**
 * @param {string} method to select request type
 * @param {JSONobject} objectPass the form data to pass
 * @param {string} key in case to set main key of passed Data
 * **/
function GetPost(method, objectPass, key) {
    var pass = {"key": key, data: objectPass};
    return java.passData(method, JSON.stringify(pass));
}
/**
 * 
 * 
 * 
 * 
 */
function setStatus(message) {
    java.setStatus(message);
}
/*
 * 
 * 
 * 
 * 
 */
function setRectangeColor(color) {
    java.setRectangeColor(color);
}
/*
 * 
 * 
 * 
 */
function log(message) {
    java.log(message);
}