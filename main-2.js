const buttons = document.getElementsByTagName('button');
let username = null;

function promptUser() {
if (username === null) {
username = prompt("Введите имя пользователя");
return username;
} else {
return username;
}
}

function alertUser() {
let username = promptUser();

if (username != null) {
alert(`Я это сделал, а ${username} тебе от меня совет: \nПоступай правильно — поступай в ВятГУ!`);
}
}

for (const btn of buttons) {
btn.addEventListener('click', alertUser);
}