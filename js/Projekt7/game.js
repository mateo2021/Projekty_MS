const gameSummary ={
    games:0,
    wins:0,
    losses:0,
    draws:0
}

const game ={
    playerHand:"",
    aiHand:"",
}
const hands = [...document.querySelectorAll('.select img')];

const  handSelection=(e)=>{

    game.playerHand = e.target.dataset.option;
    
    hands.forEach(hand => hand.style.boxShadow = "")
    e.target.style.boxShadow = "0 0 0 4px yellow";

}
function aiOption(){
   const aiOp =  hands[Math.floor(Math.random()*hands.length)].dataset.option;  
   return aiOp;
  // console.log(aiOp);
}

function checkResult(player,ai){
    if(player == ai){
        return 'draw';
    }else if((player == 'papier'&& ai=='kamień')||(player == 'nożyczki'&& ai=='papier')
    ||(player == 'kamień'&& ai=='nożyczki')){
        return 'win';
    }else{
        return 'loss';
    }
}

function publicResult(player,ai,result){
    document.querySelector('[data-summary="your-choice"]').textContent = player;
    document.querySelector('[data-summary="ai-choice"]').textContent = ai;
    document.querySelector('.numbers span').textContent = ++gameSummary.games;
    console.log(result)

    if(result === 'draw'){
        document.querySelector('[data-summary="who-win"]').textContent = "Remis !!"; 
        document.querySelector('[data-summary="who-win"]').style.color = "orange";
        document.querySelector('.draws span').textContent = ++gameSummary.draws;
    }else if(result === 'win'){
        document.querySelector('[data-summary="who-win"]').textContent = "Wygrałeś !!"; 
        document.querySelector('[data-summary="who-win"]').style.color = "green";
        document.querySelector('.wins span').textContent = ++gameSummary.wins;
    }else{
        document.querySelector('[data-summary="who-win"]').textContent = "Przegrałeś !!"; 
        document.querySelector('[data-summary="who-win"]').style.color = "red";
        document.querySelector('.losses span').textContent = ++gameSummary.losses;
    }
}

function clear(){
document.querySelector(`[data-option = "${game.playerHand}"]`).style.boxShadow="";
game.playerHand="";
game.aiHand="";
}


function mainFunction(){
    if(game.playerHand ==""){
        return alert('Zaznacz odpowiadnia opcje')
    }

    game.aiHand = aiOption();

    const gameResult = checkResult(game.playerHand,game.aiHand);
    //console.log(gameResult);

    publicResult(game.playerHand,game.aiHand,gameResult);

    clear();
}

hands.forEach(hand=>hand.addEventListener('click',handSelection));

document.querySelector('.start').addEventListener('click',mainFunction);