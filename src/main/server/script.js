var socket = io();

var messages = document.getElementById('messages');
var form = document.getElementById('form');
var input = document.getElementById('input');

form.addEventListener('submit', function (e) {
    e.preventDefault();
    if (input.value) {
        socket.emit('message', input.value);
        input.value = '';
    }
});

socket.on('message', function (message) {
    var item = document.createElement('li');
    item.textContent = message;
    messages.appendChild(item);
    window.scrollTo(0, document.body.scrollHeight);
});