const buttons = document.getElementsByTagName('button');

function alertUser() {
alert(`Макет был реализован Бутолиным П.И. Вариант №3`);

}

for (const btn of buttons) {
btn.addEventListener('click', alertUser);
}