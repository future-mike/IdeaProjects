function test(){
    let request= new XMLHttpRequest();
    request.open('GET','/login');
    request.send();
    window.location.replace("/index");
}
