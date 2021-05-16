const add = document.querySelector('button:nth-of-type(1)');
const reset = document.querySelector('button:nth-of-type(2)');

const showAdvice = document.querySelector('.showAdvice');
const showAllAdvices = document.querySelector('.showAllAdvices');
const input = document.getElementById('add');
const tab = [];


const addFunction = function(e){
    e.preventDefault();

    const word =input.value;
    if(word.length){
        for(words of tab){
            if(words == word){
                alert('Podano już taką możliwość');
                input.value = "";
                return;                
            }
        }
        tab.push(word);
        input.value = "";
    }else{
        alert('Nie podano możliwości')
    }
    console.log(tab);

}

const resetFunction =(e)=>{
 e.preventDefault();
 tab.length = 0;
 console.log(tab);
}

const showAdviceFunction =function(e){
 e.preventDefault();

 const index = Math.floor(Math.random()*tab.length);

 document.querySelector('h1').textContent = tab[index];

 console.log(index);
}

const showAllAdvicesFunction =(e)=>{
 e.preventDefault();

     alert(tab);
 
}




add.addEventListener('click',addFunction);
reset.addEventListener('click',resetFunction);
showAdvice.addEventListener('click',showAdviceFunction);
showAllAdvices.addEventListener('click',showAllAdvicesFunction);