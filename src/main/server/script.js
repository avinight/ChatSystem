var socket = new WebSocket("ws://localhost:3000/ws");

var messages = document.getElementById('messages');
var form = document.getElementById('form');
var input = document.getElementById('input');

socket.onopen = function () {
    console.log("WebSocket connection established");
    socket.send(`Hello, ${socket.id}!`);

};

socket.onmessage = function (event) {
    console.log("Received message from server:", event.data);
};

form.addEventListener('submit', function (e) {
    e.preventDefault();
    if (input.value) {
        socket.send(input.value);
        input.value = '';
    }
});

socket.onmessage = function (event) {
    var item = document.createElement('li');
    item.textContent = event.data;
    messages.appendChild(item);
    window.scrollTo(0, document.body.scrollHeight);
};

socket.onclose = function () {
    console.log("WebSocket connection closed");
};
