var socket = new WebSocket("ws://localhost:3000/ws");

var messages = document.getElementById('messages');
var form = document.getElementById('form');
var input = document.getElementById('input');

form.addEventListener('submit', function (e) {
    e.preventDefault();
    if (input.value) {
        // Send a message over the WebSocket connection
        socket.emit('message', input.value);
        input.value = '';
    }
});

// Listen for messages from the server
socket.on('message', function (message) {
    var item = document.createElement('li');
    item.textContent = message;
    messages.appendChild(item);
    window.scrollTo(0, document.body.scrollHeight);
});
