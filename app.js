const STARTING_POKER_CHIPS = 100;
const PLAYERS = 3;
const NO_OF_STARTER_CARDS = 2;
let gameHasEnded = false;
let playerOneName = "Chloe";
let playerTwoName = "Jasmine";
let playerThreeName = "Jen";
let pOnePoints = STARTING_POKER_CHIPS;
let pTwoPoints = STARTING_POKER_CHIPS;
let pThreePoints = STARTING_POKER_CHIPS;
console.log(`Добро пожаловать в Техасский Холдем. Титулом чемпиона будет награждён один из этих трёх игроков: ${playerOneName}, ${playerTwoName} и ${playerThreeName}. У каждого игрока есть ${STARTING_POKER_CHIPS} в их пуле.Пусть выиграет сильнеший!`)
pOnePoints -= 25;
pTwoPoints -= 50;
pThreePoints += 75;
gameHasEnded = ((pOnePoints + pTwoPoints) == 0) || // three has won
               ((pTwoPoints + pThreePoints) == 0) ||  // one has won
               ((pOnePoints + pThreePoints) == 0);  // two has won 
console.log("Game has ended: ", gameHasEnded);